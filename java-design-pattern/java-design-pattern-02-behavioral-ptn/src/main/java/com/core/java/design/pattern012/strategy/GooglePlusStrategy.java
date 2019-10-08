package com.core.java.design.pattern012.strategy;

/**
 * The Class GooglePlusStrategy.<BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since Oct 9, 2019 <BR>
 *        java-design-pattern-02-behavioral-ptn system <BR>
 *        com.core.java.design.pattern012.strategy <BR>
 *        GooglePlusStrategy.java <BR>
 */
public class GooglePlusStrategy implements ISocialMediaStrategy {

	/**
	 * Connect to.
	 *
	 * @param friendName the friend name
	 */
	@Override
	public void connectTo(final String friendName) {
		System.out.println("Connecting with " + friendName + " through GooglePlus");
	}
}