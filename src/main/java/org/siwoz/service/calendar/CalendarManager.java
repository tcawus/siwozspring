package org.siwoz.service.calendar;


public class CalendarManager {

//	final String LOGIN = "siwoz2014@gmail.com", PASSWORD = "siwoz20142014";
//	URL postUrl;
//	CalendarService calendarService;
//
//	public void connect() {
//		try {
//			calendarService = new CalendarService("exampleCo-exampleApp-1.0");
//			calendarService.setUserCredentials("siwoz2014@gmail.com",
//					"siwoz20142014");
//			postUrl = new URL(
//					"http://www.google.com/calendar/feeds/siwoz2014@gmail.com/private/full");
//		} catch (AuthenticationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public void insertEvent(String title, String content, DateTime startTime,
//			DateTime endTime) {
//		CalendarEventEntry myEvent = new CalendarEventEntry();
//		myEvent.setTitle(new PlainTextConstruct(title));
//		myEvent.setContent(new PlainTextConstruct(content));
//
//		When eventTimes = new When();
//		eventTimes.setStartTime(startTime);
//		eventTimes.setEndTime(endTime);
//		myEvent.addTime(eventTimes);
//
//		try {
//			calendarService.insert(postUrl, myEvent);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public void clearEvents() {
//		CalendarFeed resultFeed;
//		try {
//			resultFeed = calendarService.getFeed(postUrl, CalendarFeed.class);
//			for (int i = 0; i < resultFeed.getEntries().size(); i++) {
//				CalendarEntry entry = resultFeed.getEntries().get(i);
//				entry.delete();
//			}
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (ServiceException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}
}
