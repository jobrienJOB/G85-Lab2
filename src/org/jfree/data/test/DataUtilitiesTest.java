package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import javax.print.attribute.standard.OutputDeviceAssigned;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import junit.framework.Assert;
//import junit.framework.TestCase;

public class DataUtilitiesTest {

	private double[] testArray;
	private double[][] testArray2D;
	private KeyedValues keyedValues;
	private KeyedValues negKeyedValues;

	@Before
	public void setUp() throws Exception {

		testArray = new double[] { 1.5, -3.2, 4.6 };
		testArray2D = new double[][] { { 5.5, 2.5 }, { 6.2, 6.1 }, { 3.0, 9.2 } };
		DefaultKeyedValues testKeyedValues = new DefaultKeyedValues();
		DefaultKeyedValues testKeyedValues2 = new DefaultKeyedValues();
		keyedValues = testKeyedValues;
		negKeyedValues = testKeyedValues2;

		testKeyedValues.addValue(0, (Number) 3.0);
		testKeyedValues.addValue(1, (Number) 8.0);
		testKeyedValues.addValue(2, (Number) 4.0);

		testKeyedValues2.addValue(0, (Number) (-3.0));
		testKeyedValues2.addValue(1, (Number) (8.0));
		testKeyedValues2.addValue(2, (Number) (-4.0));
	}

	@After
	public void tearDown() throws Exception {
		testArray = null;
		testArray2D = null;
		keyedValues = null;
		negKeyedValues = null;

	}

	@Test
	public void testCreateNumberArrayValidInput() {
		Number[] numArray = DataUtilities.createNumberArray(testArray);
		assertEquals("The created array doe not contain all the expected values", testArray[0], numArray[0]);
		assertEquals("The created array doe not contain all the expected values", testArray[1], numArray[1]);
		assertEquals("The created array doe not contain all the expected values", testArray[2], numArray[2]);

	}

	@Test
	public void testCreateNumberArrayinvalidEmptyInput() {
		testArray = new double[3];
		Number[] numArray = DataUtilities.createNumberArray(testArray);
		System.out.println(testArray[0]);
		assertEquals("The created array doe not contain all the expected values", testArray[0], numArray[0]);
		assertEquals("The created array doe not contain all the expected values", testArray[1], numArray[1]);
		assertEquals("The created array doe not contain all the expected values", testArray[2], numArray[2]);

	}

	@Test
	public void testCreateNumberArrayInvalidNullInput() {
		try {
			Number[] numArray = DataUtilities.createNumberArray(null);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}

	}

	@Test
	public void testCreate2DNumberArrayValidInput() {
		Number[][] numArray = DataUtilities.createNumberArray2D(testArray2D);
		
		assertEquals("The created array doe not contain all the expected values", testArray2D[0][0], numArray[0][0]);
		assertEquals("The created array doe not contain all the expected values", testArray2D[0][1], numArray[0][1]);
		assertEquals("The created array doe not contain all the expected values", testArray2D[1][0], numArray[1][0]);
		assertEquals("The created array doe not contain all the expected values", testArray2D[1][1], numArray[1][1]);
		assertEquals("The created array doe not contain all the expected values", testArray2D[2][0], numArray[2][0]);
		assertEquals("The created array doe not contain all the expected values", testArray2D[2][1], numArray[2][1]);

	}

	@Test
	public void testCreate2DNumberArrayValidInputNegative() {
		testArray2D = new double[][] { { -5.5, -2.5 }, { 6.2, 6.1 }, { -3.0, 9.2 } };
		Number[][] numArray = DataUtilities.createNumberArray2D(testArray2D);

		assertEquals("The created array doe not contain all the expected values", testArray2D[0][0], numArray[0][0]);
		assertEquals("The created array doe not contain all the expected values", testArray2D[0][1], numArray[0][1]);
		assertEquals("The created array doe not contain all the expected values", testArray2D[1][0], numArray[1][0]);
		assertEquals("The created array doe not contain all the expected values", testArray2D[1][1], numArray[1][1]);
		assertEquals("The created array doe not contain all the expected values", testArray2D[2][0], numArray[2][0]);
		assertEquals("The created array doe not contain all the expected values", testArray2D[2][1], numArray[2][1]);

	}

	@Test
	public void testCreate2DNumberArrayValidEmptyInput() {
		testArray2D = new double[3][2];
		Number[][] numArray = DataUtilities.createNumberArray2D(testArray2D);

		assertEquals("The created array doe not contain all the expected values", testArray2D[0][0], numArray[0][0]);
		assertEquals("The created array doe not contain all the expected values", testArray2D[0][1], numArray[0][1]);
		assertEquals("The created array doe not contain all the expected values", testArray2D[1][0], numArray[1][0]);
		assertEquals("The created array doe not contain all the expected values", testArray2D[1][1], numArray[1][1]);
		assertEquals("The created array doe not contain all the expected values", testArray2D[2][0], numArray[2][0]);
		assertEquals("The created array doe not contain all the expected values", testArray2D[2][1], numArray[2][1]);
		assertEquals("The created array doe not contain all the expected values", testArray2D[0][2], numArray[0][2]);
		assertEquals("The created array doe not contain all the expected values", testArray2D[1][2], numArray[1][2]);
		assertEquals("The created array doe not contain all the expected values", testArray2D[2][2], numArray[2][2]);

	}

	@Test
	public void testCreateNumberArray2DInvalidNullInput() {
		try {
			Number[][] numArray = DataUtilities.createNumberArray2D(null);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}

	}

	/*
	 * GetCumulativePercentages Tests
	 */
	@Test
	public void testGetCumulativePercentagesValidInput() {

		KeyedValues outputKeyedValues = DataUtilities.getCumulativePercentages(keyedValues);

		assertEquals("The cumulative percentages are incorrect", 0.2, outputKeyedValues.getValue(0));
		assertEquals("The cumulative percentages are incorrect", 0.733, outputKeyedValues.getValue(1));
		assertEquals("The cumulative percentages are incorrect", 1.0, outputKeyedValues.getValue(2));
	}

	@Test
	public void testGetCumulativePercentagesInvalidNegInputCheckForException() {
		try {
			KeyedValues outputKeyedValues = DataUtilities.getCumulativePercentages(negKeyedValues);
			fail("No exception thrown-Expected outcome was: a thrown exception, perhaps IllegalArgument");
		} catch (Exception e) {
			assertTrue(e != null);
		}
	}

	@Test
	public void testGetCumulativePercentagesInvalidNegInput() {

		KeyedValues outputKeyedValues = DataUtilities.getCumulativePercentages(negKeyedValues);
		assertTrue("The cumulative percentages are not within the expected bounds of 0.0 and 1.0",
				outputKeyedValues.getValue(0).doubleValue() >= 0.0
						&& outputKeyedValues.getValue(0).doubleValue() <= 1.0);
		assertTrue("The cumulative percentages are not within the expected bounds of 0.0 and 1.0",
				outputKeyedValues.getValue(1).doubleValue() >= 0.0
						&& outputKeyedValues.getValue(1).doubleValue() <= 1.0);
		assertTrue("The cumulative percentages are not within the expected bounds of 0.0 and 1.0",
				outputKeyedValues.getValue(2).doubleValue() >= 0.0
						&& outputKeyedValues.getValue(2).doubleValue() <= 1.0);
	}

	@Test
	public void testGetCumulativePercentagesInvalidNullInput() {
		try {
			KeyedValues outputKeyedValues = DataUtilities.getCumulativePercentages(null);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}

}
