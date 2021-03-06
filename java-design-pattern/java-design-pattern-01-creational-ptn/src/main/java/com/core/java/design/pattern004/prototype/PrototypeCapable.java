package com.core.java.design.pattern004.prototype;

/**
 * The Interface PrototypeCapable.<BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since Jul 2, 2019 <BR>
 *        java-design-pattern-01-creational-ptn system <BR>
 *        com.core.java.design.pattern004.prototype <BR>
 *        PrototypeCapable.java <BR>
 */
public interface PrototypeCapable extends Cloneable {

	/**
	 * Clone.
	 *
	 * @return PrototypeCapable
	 * @throws CloneNotSupportedException the clone not supported exception
	 */
	PrototypeCapable clone() throws CloneNotSupportedException;
}