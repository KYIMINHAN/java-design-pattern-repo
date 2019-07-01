package com.core.java.deisgn.pattern001.singleton;

import lombok.extern.log4j.Log4j2;

/**
 * The Class StaticBlockSingleton. <BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since 2019/07/01 <BR>
 *        java-design-pattern-creationals-ptn system <BR>
 *        com.core.java.deisgn.pattern001.singleton <BR>
 *        StaticBlockSingleton.java <BR>
 */
@Log4j2
public class StaticBlockSingleton {

	/** The Constant INSTANCE. */
	private static final StaticBlockSingleton INSTANCE;

	static {
		try {
			INSTANCE = new StaticBlockSingleton();
		} catch (final Exception e) {
			throw new RuntimeException("Uffff, i was not expecting this!", e);
		}
	}

	/**
	 * Gets the single instance of StaticBlockSingleton.
	 *
	 * @return single instance of StaticBlockSingleton
	 */
	public static StaticBlockSingleton getInstance() {
		return StaticBlockSingleton.INSTANCE;
	}

	/**
	 * Instantiates a new static block singleton.
	 */
	private StaticBlockSingleton() {
		// ...
	}

	/**
	 * Show.
	 */
	public void show() {
		StaticBlockSingleton.log.info("show() method in the " + this.getClass());
	}
}