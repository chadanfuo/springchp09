package gm;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GuestMessageController {
	@RequestMapping(value="/guestmessage/list.xml")
	
	@ResponseBody
	public GuestMessageList listXml(){
		return getMessageList();
		}
	private GuestMessageList getMessageList(){
		List<GuestMessage> message=Arrays.asList(
				new GuestMessage(1,"메시지",new Date()),
				new GuestMessage(2,"메시지2",new Date())
				);
		return new GuestMessageList(message);
	}
	@RequestMapping(value="/guestmessage/post.xml",method=RequestMethod.POST)
	@ResponseBody
	public GuestMessageList postXml(@RequestBody GuestMessageList messageList){
		
		System.out.println("====="+messageList.getMessages());
		return messageList;
	}
	
	@RequestMapping(value="/guestmessage/list.json")
	@ResponseBody
	public GuestMessageList2 getMessageList2(){
		List<GuestMessage> message=Arrays.asList(
				new GuestMessage(1,"메시지",new Date()),
				new GuestMessage(2,"메시지2",new Date())
				);
		return new GuestMessageList2(message);
	}
}
