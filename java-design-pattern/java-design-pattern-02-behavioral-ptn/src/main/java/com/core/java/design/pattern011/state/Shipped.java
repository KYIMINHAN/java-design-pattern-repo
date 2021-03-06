package com.core.java.design.pattern011.state;

/**
 * The Class Shipped.<BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since Oct 9, 2019 <BR>
 *        java-design-pattern-02-behavioral-ptn system <BR>
 *        com.core.java.design.pattern011.state <BR>
 *        Shipped.java <BR>
 */
public class Shipped implements PackageState {

	/** The instance. */
	// Singleton
	private static Shipped instance = new Shipped();

	/**
	 * Instantiates a new shipped.
	 */
	private Shipped() {
	}

	/**
	 * Instance.
	 *
	 * @return Shipped
	 */
	public static Shipped instance() {
		return Shipped.instance;
	}

	/**
	 * Update state.
	 *
	 * @param ctx the ctx
	 */
	// Business logic and state transition
	@Override
	public void updateState(final DeliveryContext ctx) {
		System.out.println("Package is shipped !!");
		ctx.setCurrentState(InTransition.instance());
	}
}