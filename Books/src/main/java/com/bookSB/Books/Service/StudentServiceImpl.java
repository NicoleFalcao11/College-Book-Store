package com.bookSB.Books.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookSB.Books.DTO.SignupRequest;
import com.bookSB.Books.Entity.Book;
import com.bookSB.Books.Entity.Cart;
import com.bookSB.Books.Entity.Role;
import com.bookSB.Books.Entity.Student;
import com.bookSB.Books.Exceptions.StudentNotFoundException;
import com.bookSB.Books.Repository.BookRepository;
import com.bookSB.Books.Repository.BuySellRepository;
import com.bookSB.Books.Repository.CartRepo;
import com.bookSB.Books.Repository.RoleRepository;
import com.bookSB.Books.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository srepo;
	private final EmailService emailService;
	private RoleRepository rrepo;
	private final PasswordEncoder passwordEncoder;
	private final BuySellRepository bs;
	private final BookRepository b;
	private final CartRepo cRepo;
	
	@Autowired
	public StudentServiceImpl(StudentRepository srepo , EmailService emailService , RoleRepository rrepo, PasswordEncoder passwordEncoder , BuySellRepository bs , BookRepository b, CartRepo cRepo) {
		this.srepo = srepo;
		this.emailService = emailService;
		this.rrepo = rrepo;
		this.passwordEncoder = passwordEncoder;
		this.bs = bs;
		this.b = b;
		this.cRepo = cRepo;
	}
	
//	@Autowired
//	private ModelMapper model;
	
	
	public String getNameById(Long RollNo) {
		// TODO Auto-generated method stub
		Optional<Student> opt = srepo.findById(RollNo);
		Student s = opt.get();
		return s.getName();
	}
	
	public String getMobnoById(Long RollNo) {
		// TODO Auto-generated method stub
		Optional<Student> opt = srepo.findById(RollNo);
		Student s = opt.get();
		return s.getMobNo();
	}
	
	public String getEmailById(Long RollNo) {
		// TODO Auto-generated method stub
		Optional<Student> opt = srepo.findById(RollNo);
		Student s = opt.get();
		return s.getEmail();
	}


	
	@Override
	public Student createStudent(SignupRequest s) {

		if (srepo.existsByEmail(s.getEmail() )) {
			return null;
        }
		
		Student student = new Student();
		Role role = new Role();
        BeanUtils.copyProperties(s , student);
        System.out.println("\nIn AuthServiceImpl");
        System.out.println(student);
        //Hash the password before saving
        String hashPassword = passwordEncoder.encode(s.getPassword());
        student.setPassword(hashPassword);
        Long roll = s.getRollNo();
        student.setRollNo(roll);
        
        String Rolename = s.getRolename();
        role.setStudent_id(student);
        role.setRolename(Rolename);
        
        String otp = generateOTP();
        student.setOtp(otp);
        
        Student saved = srepo.save(student);
        role.setName(saved.getName());
        role.setEmail(saved.getEmail());
        rrepo.save(role);
        sendVerificationEmail(saved.getEmail(), otp);
		
		return student;
	}

	
	private String generateOTP(){
        Random random = new Random();
        int otpValue = 100000 + random.nextInt(900000);
        return String.valueOf(otpValue);
    }
	
	private void sendVerificationEmail(String email,String otp){
        String subject = "Sign Up Email Verification";
        String body ="Welcome To The BookStore\nYour Verification OTP is: "+otp;
        emailService.sendEmail(email,subject,body);
    }
	
	private void sendNotificationEmail(String email, String bkname , SignupRequest s){
        String subject = "Book Buyer Interest Notification Email";
        String body ="Hello from The BookStore\nYou have a new Buyer ,"+s.getName()+" interested in Buying Your Book "+bkname+"\nThe Buyer is from "+s.getDepartment()+" Department"
        		+ " Division "+s.getDivision()+" Year and Semester "+s.getYear()+"\nPlease Accept or Reject This Email to start a Chat with the Buyer or Dismiss the Request";
        emailService.sendMail(email,subject,body);
    }

	@Override
    public void verify(String email, String otp) {
        Student users = srepo.findByEmail(email);
       
        if (users == null){
            throw new RuntimeException("Student not found");
        } else if (users.isVerified()) {
            throw new RuntimeException("Student is Already Verified");
        } else if (otp.equals(users.getOtp())) {
            users.setVerified(true);
            srepo.save(users);
   
        }else {
            throw new RuntimeException("Internal Server Error");
        }
    }

	@Override
	//Exception to be Added here
	public SignupRequest updateStudent(SignupRequest s, Long sid) {
		// TODO Auto-generated method stub
		Optional<Student> optionalS = srepo.findById(sid);  //.orElseThrow(()-> new ResourcreNotFoundException("Student","sid",sid) ) ;
		Student stud = optionalS.get();
		stud.setName(s.getName());
		stud.setRollNo(s.getRollNo());
		stud.setEmail(s.getEmail());
		stud.setDepartment(s.getDepartment());
		stud.setYear(s.getYear());
		stud.setDivision(s.getDivision());
		stud.setPassword(s.getPassword());
		stud.setMobNo(s.getMobNo());
		srepo.save(stud);
		return s;
		
	}


	
	@Override
	public SignupRequest getStudentById(Long sid) {
	    Optional<Student> opt = srepo.findById(sid);
	    Student s = opt.orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + sid));
	    SignupRequest sr = new SignupRequest();
	    BeanUtils.copyProperties(s , sr);
	    return sr;
	}
	


	@Override
	public String DeleteStudentById(Long sid) {
		// TODO Auto-generated method stub
		srepo.deleteById(sid);
		return "Student "+sid+" Has Been Deleted";
		
	}

	//Books On Sell but not Sold
	@Override
	public List<Book> getBookBySellerId(Long sid) {
		List <Long> bookIds = bs.findBooksSoldIdByseller(sid);
		System.out.println(b.findAllById(bookIds));
		return b.findAllById(bookIds);
	}
	
	//Books Sold
	@Override
	public List<Book> getBooksSold(Long sid) {
		List <Long> bookIds = bs.findBooksSoldIdByseller(sid);
		return b.findAllById(bookIds);
		
	}

	@Override
	public List<Book> getBookByBuyerId(Long sid) {
		List <Long> bookIds = bs.findBookIdBybuyId(sid);
		
		return b.findAllById(bookIds);
		
	}
	
	@Override
	public List<Book> getRecentBooks() {
		return b.findRecentBooks();
	}

	@Override
	public List<Book> getCartItems(Long rollno) {
		// TODO Auto-generated method stub
		List<Book> items = new ArrayList<>();
		List<Long> bkids = cRepo.findBookIdByrollno(rollno);
		items = b.findAllById(bkids);
		return items;
	}

	@Override
	public void addCartItem(Long rollno, Long bkid) {
		// TODO Auto-generated method stub
		Cart c = new Cart();
		c.setRollno(rollno);
		c.setBookid(bkid);
		cRepo.save(c);
		
	}

	@Override
	public String deleteCartItem(Long rollno, Long bkid) {
		// TODO Auto-generated method stub
		List<Long> ids = cRepo.deleteByRollnoAndBkid(rollno, bkid);
		cRepo.deleteAllById(ids);
		return "Item Deleted Successfully";
	}

	@Override
	public String notifySeller(String email , String bkname , SignupRequest buyer) {
		// TODO Auto-generated method stub
		sendNotificationEmail(email, bkname, buyer);
		
		return "Seller Notified";
	}


}
