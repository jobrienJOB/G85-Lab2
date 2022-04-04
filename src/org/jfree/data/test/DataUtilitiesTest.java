package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;


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
	private Values2D values2DColumn;
	private Values2D values2DRow;

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
		DefaultKeyedValues2D testValuesColumn = new DefaultKeyedValues2D();
		values2DColumn = testValuesColumn;
		testValuesColumn.addValue(1, 1, 1);
		testValuesColumn.addValue(4, 1, 2);
		testValuesColumn.addValue(7, 1, 3);

		testValuesColumn.addValue(3, 2, 1);
		testValuesColumn.addValue(9, 2, 2);
		testValuesColumn.addValue(4, 2, 3);

		DefaultKeyedValues2D testValuesRow = new DefaultKeyedValues2D();

		values2DRow = testValuesRow;
		testValuesRow.addValue(1, 1, 1);
		testValuesRow.addValue(3, 1, 2);

		testValuesRow.addValue(4, 2, 1);
		testValuesRow.addValue(9, 2, 2);

		testValuesRow.addValue(7, 3, 1);
		testValuesRow.addValue(4, 3, 2);
	}

	@After
	public void tearDown() throws Exception {
		testArray = null;
		testArray2D = null;
		keyedValues = null;
		negKeyedValues = null;
		values2DColumn = null;
		values2DRow = null;

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

	@Test
	public void testCalculateColumnTotalReturns0WhenAnInvalidColumnIsSpecified() {
		try {
			assertEquals("Wrong sum returned - it should be 0", 0,
					DataUtilities.calculateColumnTotal(values2DColumn, 3), 0.000000001d);
		} catch (Exception e) {
			fail("Exception thrown");
		}

	}

	@Test
	public void testCalculateColumnTotalReturns13WhenColumnIndexIs1() {
		assertEquals("Wrong sum returned - it should be 13", 13, DataUtilities.calculateColumnTotal(values2DColumn, 1),
				0.000000001d);
	}

	@Test
	public void testCalculateColumnTotalReturns0WhenInvalidColumnIndex3IsSpecified() {
		try {
			assertEquals("Wrong sum returned - it should be 0", 0,
					DataUtilities.calculateColumnTotal(values2DColumn, 3), 0.000000001d);
		} catch (Exception e) {
			fail("Exception thrown");
		}
	}

	@Test
	public void testCalculateColumnTotalReturns4WhenColumnIndexIs0() {
		assertEquals("Wrong sum returned - it should be 4", 4, DataUtilities.calculateColumnTotal(values2DColumn, 0),
				0.000000001d);
	}

	@Test
	public void testColumnTwoTotalReturns11WhenColumnIndexIs2() {
		try {
			assertEquals("Wrong sum returned - it should be 11", 11,
					DataUtilities.calculateColumnTotal(values2DColumn, 2), 0.000000001d);
		} catch (Exception e) {
			fail("Exception thrown");
		}
	}

	@Test
	public void testCalculateColumnTotalReturnsInvalidParameterExceptionWhenNullValueIsPassedIn() {
		try {
			DataUtilities.calculateColumnTotal(null, 1);
			fail("Did not throw an exception");

		} catch (Exception e) {
			assertTrue("Did not throw expected exception type", e.getClass().equals(InvalidParameterException.class));
		}
	}

	@Test
	public void testCalculateColumnTotalReturns0WhenKeyedValues2DIsEmpty() {
		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();
		values2DColumn = testEmpty;
		assertEquals("Wrong sum returned - it should be 0", 0, DataUtilities.calculateColumnTotal(values2DColumn, 0),
				0.000000001d);
	}

	@Test
	public void testCalculateRowTotalReturns0WhenRowNegative1IndexIsSpecified() {
		try {
			assertEquals(0, DataUtilities.calculateRowTotal(values2DRow, -1), 0.000000001d);
		} catch (Exception e) {
			fail("Exception thrown");
		}
	}

	@Test
	public void testCalculateRowTotalReturns13WhenRowIndexIsOne() {
		assertEquals("Wrong sum returned - it should be 13", 13.0, DataUtilities.calculateRowTotal(values2DRow, 1),
				0.000000001d);
	}

	@Test
	public void testCalculateRowTotalReturns0WhenRowIndexIsThree() {
		try {
			assertEquals("Wrong sum returned - it should be 0", 0, DataUtilities.calculateRowTotal(values2DRow, 3), 0.000000001d);
		} catch (Exception e) {
			fail("Exception thrown");
		}
	}

	@Test
	public void testCalculateRowTotalReturns4WhenRowIndexIs0() {
		try {
			assertEquals("Wrong sum returned - it should be 4", 4, DataUtilities.calculateRowTotal(values2DRow, 0), 0.000000001d);
		} catch (Exception e) {
			fail("Exception thrown");
		}
	}

	@Test
	public void testCalculateRowTotalReturns11WhenRowIndex2() {
		try {
			assertEquals("Wrong sum returned - it should be 11", 11, DataUtilities.calculateRowTotal(values2DRow, 2), 0.000000001d);
		} catch (Exception e) {
			fail("Exception thrown");
		}
	}
	
	//This test should return 0. However, it returns a NullPointerException, 
	//therefore, in order to have a valid test - we must catch an exception before the test
	//is classed as an error.
	@Test
	public void testCalculateRowTotalReturns0WhenNullValueIsPassedIn() {
		try {
			assertEquals("Wrong sum returned - it should be 0", 0, DataUtilities.calculateRowTotal(null, 0), 0.000000001d);

		} catch (Exception e) {
			fail("Exception thrown");
		}
	}

	@Test
	public void testCalculateRowTotalReturns0WhenRowIndexIs0() {
		try {
			DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();
			values2DRow = testEmpty;
			assertEquals("Wrong sum returned - it should be 0",0, DataUtilities.calculateRowTotal(values2DRow, 0), 0.000000001d);
		} catch (Exception e) {
			fail("Exception thrown");
		}
	}
}
