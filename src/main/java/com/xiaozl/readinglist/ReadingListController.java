package com.xiaozl.readinglist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/readingList")
public class ReadingListController {

	private static final String reader = "craig";

	private ReadingListRepository readingListRepository;

	private AmazonProperties amazonProperties;

	@Autowired
	public ReadingListController(ReadingListRepository readingListRepository,
								 AmazonProperties amazonProperties) {
		this.readingListRepository = readingListRepository;
		this.amazonProperties = amazonProperties;
	}


//	public void setAssociateId(String associateId) {
//		this.associateId = associateId;
//	}
	
//	@RequestMapping(method=RequestMethod.GET)
//	public String readersBooks(Reader reader,Model model) {
//
//		List<Book> readingList = readingListRepository.findByReader(reader);
//		if (readingList != null) {
//			model.addAttribute("books", readingList);
//		}
//		return "readingList";
//	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addToReadingList(Book book) {
		book.setReader(reader);
		readingListRepository.save(book);
		return "redirect:/readingList";
	}

	@RequestMapping(method=RequestMethod.GET)
	public String readersBooks(String reader, Model model) {
		List<Book> readingList =
				readingListRepository.findByReader(reader);
		if (readingList != null) {
			model.addAttribute("books", readingList);
			model.addAttribute("reader", reader);
			model.addAttribute("amazonID", amazonProperties.getAssociateId());
		}
		return "readingList";
	}


}
