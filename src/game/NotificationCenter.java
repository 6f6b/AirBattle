package game;

import javax.management.NotificationBroadcasterSupport;

public class NotificationCenter extends NotificationBroadcasterSupport {
	private static NotificationCenter defaultCenter = new NotificationCenter();
	
	private NotificationCenter() {
		
	}
	
	public static NotificationCenter defaultCenter() {
		return defaultCenter;
	}
}