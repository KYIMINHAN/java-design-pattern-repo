package com.core.java.deisgn.pattern003.abstractFactory;

/**
 * The Class AsiaCarFactory. <BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since 2019/07/01 <BR>
 *        java-design-pattern-creationals-ptn system <BR>
 *        com.core.java.deisgn.pattern003.abstractFactory <BR>
 *        AsiaCarFactory.java <BR>
 */
public class AsiaCarFactory {

	/**
	 * Builds the car.
	 *
	 * @param model the model
	 * @return Car
	 */
	public static Car buildCar(final CarType model) {

		Car car = null;
		switch (model) {
		case SMALL:
			car = new SmallCar(Location.ASIA);
			break;

		case SEDAN:
			car = new SedanCar(Location.ASIA);
			break;

		case LUXURY:
			car = new LuxuryCar(Location.ASIA);
			break;

		default:
			// throw some exception
			break;
		}
		return car;
	}
}