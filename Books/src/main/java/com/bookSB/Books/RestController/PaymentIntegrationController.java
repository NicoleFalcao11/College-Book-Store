package com.bookSB.Books.RestController;


import java.util.Date;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookSB.Books.DTO.TransactDTO;
import com.bookSB.Books.Entity.Book;
import com.bookSB.Books.Entity.Buyer_Seller;
import com.bookSB.Books.Repository.BookRepository;
import com.bookSB.Books.Repository.BuySellRepository;
import com.bookSB.Books.Service.BookService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
public class PaymentIntegrationController {
	
	private BookService Bk;
	private BookRepository b;
	private BuySellRepository buys;
	
	@Autowired
	public PaymentIntegrationController(BookService Bk ,BookRepository b , BuySellRepository buys) {
		this.Bk = Bk;
	    this.b = b;
	    this.buys = buys;
	}
	
    @Value("${rzp_key_id}")
    private String keyId;

    @Value("${rzp_key_secret}")
    private String secret;
    
    @PostMapping("/payment/{amount}")
    public String Payment(@PathVariable Double amount , @RequestBody TransactDTO t) throws RazorpayException {
        
        RazorpayClient razorpayClient = new RazorpayClient(keyId, secret);
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount);
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "order_receipt_11");

        Order order = razorpayClient.orders.create(orderRequest);
        String orderId = order.get("id");
        
        System.out.println("\nData is "+t);
        
        Book bk = Bk.getBookById(t.getBookId());
        System.out.println("\nBook is "+bk);
        System.out.println("\nPrice Vs Price"+bk.getPrice()+""+t.getAmount());
        
        if(bk.getPrice() == t.getAmount()) {
        
        Buyer_Seller bs = new Buyer_Seller();
        bs.setBuyId(t.getBuyId());
        bs.setBookId(t.getBookId());
        bs.setAmount(t.getAmount());
        bs.setSellId(t.getSellId());
        bs.setOrder_id(orderId);
        Date date = new Date();
        bs.setDate(date);
        buys.save(bs);
        
        b.setAvailToFalse(t.getBookId());
        System.out.println("\nTransaction Succesfull "+orderId);
        return orderId;
        
        }
        
        return null;
        
    }
}
