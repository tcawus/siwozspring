//package calendar;
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.google.gdata.client.calendar.CalendarQuery;
//import com.google.gdata.client.calendar.CalendarService;
//import com.google.gdata.data.DateTime;
//import com.google.gdata.data.PlainTextConstruct;
//import com.google.gdata.data.calendar.CalendarEventEntry;
//import com.google.gdata.data.calendar.CalendarEventFeed;
//import com.google.gdata.data.extensions.When;
//import com.google.gdata.util.AuthenticationException;
//import com.google.gdata.util.ServiceException;
//
//public class CalendarTest {
//
//	CalendarService myService;
//	URL postUrl;
//	URL feedUrl;
//
//	@Before
//	public void before() {
//		myService = new CalendarService("exampleCo-exampleApp-1.0");
//		try {
//			myService
//					.setUserCredentials("siwoz2014@gmail.com", "siwoz20142014");
//			postUrl = new URL(
//					"http://www.google.com/calendar/feeds/siwoz2014@gmail.com/private/full");
//			feedUrl = new URL(
//					"http://www.google.com/calendar/feeds/default/allcalendars/full");
//		} catch (AuthenticationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void test() {
//		try {
//			CalendarEventEntry myEvent = new CalendarEventEntry();
//
//			// Set the title and description
//			myEvent.setTitle(new PlainTextConstruct("Pi Day Party"));
//			myEvent.setContent(new PlainTextConstruct(
//					"I am throwing a Pi Day Party!"));
//
//			// Create DateTime events and create a When object to hold them,
//			// then add
//			// the When event to the event
//			DateTime startTime = DateTime
//					.parseDateTime("2014-03-14T15:00:00-08:00");
//			DateTime endTime = DateTime
//					.parseDateTime("2014-03-14T17:00:00-08:00");
//			When eventTimes = new When();
//			eventTimes.setStartTime(startTime);
//			eventTimes.setEndTime(endTime);
//			myEvent.addTime(eventTimes);
//
//			// POST the request and receive the response:
//			myService.insert(postUrl, myEvent);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AuthenticationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void getAllTest() {
//		try {
//			// Create a new query object and set the parameters
//			CalendarQuery myQuery = new CalendarQuery(postUrl);
//			myQuery.setMinimumStartTime(DateTime
//					.parseDateTime("2013-03-16T00:00:00"));
//			myQuery.setMaximumStartTime(DateTime
//					.parseDateTime("2015-03-24T23:59:59"));
//
//			CalendarEventFeed myResultsFeed = myService.query(myQuery,
//					CalendarEventFeed.class);
//			if (myResultsFeed.getEntries().size() > 0) {
//				CalendarEventEntry firstMatchEntry = (CalendarEventEntry) myResultsFeed
//						.getEntries().get(0);
//				String myEntryTitle = firstMatchEntry.getTitle().getPlainText();
//				System.out.println(myEntryTitle);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
