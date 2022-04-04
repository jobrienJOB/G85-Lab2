package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;


import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {

	private Range rangeObjectUnderTest;
	private Range constrainRangeObjectUnderTest;
	private Range expandRangeObjectUnderTest;
	private Range expectedExpandedRange;
	private Range range;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
		constrainRangeObjectUnderTest = new Range(-5.00, 5.00);
		expandRangeObjectUnderTest = new Range(-7.5, 12.0);
		expectedExpandedRange = new Range(-7.5, 12);
		range = new Range(-5, 5);

	}

	@After
	public void tearDown() throws Exception {
		rangeObjectUnderTest = null;
		constrainRangeObjectUnderTest = null;
		expandRangeObjectUnderTest = null;
		expandRangeObjectUnderTest = null;
		range = null;
	}
	@Test
	public void testGetLengthReturns3WhenRangeHasBothPositiveValues() {
		Range r1 = new Range(5, 8);
		assertEquals("getLength did not return 3.0", 3.0, r1.getLength(), 0.000000001d);
	}
	@Test
	public void testGetLengthReturns12WhenRangeHasBothNegativeValues() {
		Range r1 = new Range(-15, -3);
		assertEquals("getLength did not return 12.0", 12.0, r1.getLength(), 0.000000001d);
	}

	@Test
	public void testGetLengthReturns7WhenRangeValueOnLeftIsNegativeAndRangeValueOnRightIsPositive() {
		Range r1 = new Range(-1, 6);
		assertEquals("getLength did not return 7.0", 7.0, r1.getLength(), 0.000000001d);
	}

	@Test
	public void testGetLengthReturns0WhenBothPositiveRangeValuesAreEqual() {
		Range r1 = new Range(24, 24);
		assertEquals("getLength did not return 0.0", 0.0, r1.getLength(), 0.000000001d);
	}

	@Test
	public void testGetLengthReturns0WhenBothNegativeRangeValuesAreEqual() {
		Range r1 = new Range(-18, -18);
		assertEquals("getLength did not return 0.0", 0.0, r1.getLength(), 0.000000001d);
	}

	@Test
	public void testContainsReturnsTrueWhenBooleanMethodPassesInAValidValue() {
		assertEquals("contains method did not return true", true, range.contains(0.5));
	}

	@Test
	public void testContainsReturnsFalseWhenValueOnLeftIsOutsideTheRange() {
		assertEquals("contains method did not return false", false, range.contains(-8.0));
	}

	@Test
	public void testContainsReturnsFalseWhenValueOnRightIsOutsideTheRange() {
		assertEquals("contains method did not return false", false, range.contains(10.4));
	}
	
	@Test
	public void testContainsReturnsTrueWhenValueIsEqualToLowerBoundary() {
		assertEquals("contains method did not return true", true, range.contains(-5.0));
	}

	@Test
	public void testContainsTrueWhenValueIsEqualToUpperBoundary() {
		assertEquals("contains method did not return true", true, range.contains(5.0));
	}

	@Test
	public void testContainsReturnsFalseWhenBoundaryValueIsANegativeUpperValue() {
		assertEquals("contains method did not return false", false, range.contains(-5.01));
	}

	@Test
	public void testContainsReturnsTrueWhenBoundaryValueIsANegativeLowerValue() {
		assertEquals("contains method did not return true", true, range.contains(-4.99));
	}
	
	@Test
	public void testContainsReturnsTrueWhenBoundaryValueIsAPositiveLowerValue() {
		assertEquals("contains method did not return true", true, range.contains(4.99));
	}

	@Test
	public void testContainsReturnsFalseWhenBoundaryValueIsAPositiveUpperValue() {
		assertEquals("contains method did not return false", false, range.contains(5.01));
	}

	/*
	 * 
	 * Constrain(double value) Method Tests
	 * 
	 */
	@Test
	public void testConstrainValueInRangeShouldReturnInputValue() {
		assertEquals("The value returned by constrain with input 0.5 should be the same as input value", 0.5,
				constrainRangeObjectUnderTest.constrain(0.5), 0.000000001d);
	}

	@Test
	public void testConstrainValueBelowLowerBoundShouldReturnLowerBound() {
		assertEquals("The constrain value within range closest to input -8 is lower bound value -5.0", -5.0,
				constrainRangeObjectUnderTest.constrain(-8.0), 0.000000001d);
	}

	@Test
	public void testConstrainValueAboveUpperBoundShouldReturnUpperBound() {
		assertEquals("The returned value within range closest to input 10.4 is upper bound value 5.0", 5.0,
				constrainRangeObjectUnderTest.constrain(10.4), 0.000000001d);
	}

	@Test
	public void testConstrainValueEqualToLowerBoundShouldReturnLowerBound() {
		assertEquals("The returned value within range closest to input -5.0 is upper bound value -5.0", -5.0,
				constrainRangeObjectUnderTest.constrain(-5.0), 0.000000001d);
	}

	@Test
	public void testConstrainValueEqualToUpperBoundShouldReturnUpperBound() {
		assertEquals("The returned value within range closest to input 5.0 is upper bound value 5.0", 5.0,
				constrainRangeObjectUnderTest.constrain(5.0), 0.000000001d);
	}

	@Test
	public void testConstrainValueJustBelowLowerBoundShouldReturnLowerBound() {
		assertEquals("The returned value within range closest to input -5.01 is lower bound value -5.0", -5.0,
				constrainRangeObjectUnderTest.constrain(-5.01), 0.000000001d);
	}

	@Test
	public void testConstrainValueJustAboveLowerBoundShouldReturnInputValue() {
		assertEquals("The returned value within range closest to input -4.99 is input value -4.99", -4.99,
				constrainRangeObjectUnderTest.constrain(-4.99), 0.000000001d);
	}

	@Test
	public void testConstrainValueJustBelowUpperBoundShouldReturnInputValue() {
		assertEquals("The returned value within range closest to input 4.99 is same as input value 4.99", 4.99,
				constrainRangeObjectUnderTest.constrain(4.99), 0.000000001d);
	}

	@Test
	public void testConstrainValueJustAboveUpperBoundShouldReturnUpperBound() {
		assertEquals("The returned value within range closest to input 5.01 is upper bound value 5.0", 5.0,
				constrainRangeObjectUnderTest.constrain(5.01), 0.000000001d);
	}

	//
	//
	// getLowerBounds() Tests
	//
	//

	@Test
	public void testGetLowerBoundUpperLowerBothPositiveShouldReturnLower() {

		rangeObjectUnderTest = new Range(5, 17);
		assertEquals("getLowerBound: Did not return the expected output", 5.0, rangeObjectUnderTest.getLowerBound(),
				0.000000001d);

	}

	@Test
	public void testGetLowerBoundUpperLowerBothNegativewShouldReturnLower() {

		rangeObjectUnderTest = new Range(-32, -4);
		assertEquals("getLowerBOund: Did not return the expected output", -32, rangeObjectUnderTest.getLowerBound(),
				0.000000001d);

	}

	@Test
	public void testGetLowerBoundLowerNegativeUpperPositiveShouldReturnLower() {

		rangeObjectUnderTest = new Range(-1, 6);
		assertEquals("getLowerBound: Did not return the expected output", -1.0, rangeObjectUnderTest.getLowerBound(), 0.000000001d);

	}

	@Test
	public void testGetLowerBoundUpperLowerEqualAndPositiveShouldReturnCorrectValue() {

		rangeObjectUnderTest = new Range(91, 91);
		assertEquals("getLowerBOund: Did not return the expected output", 91.0, rangeObjectUnderTest.getLowerBound(), 0.000000001d);

	}

	@Test
	public void testGetLowerBoundUpperLowerEqualAndNegativeShouldReturnCorrectValue() {

		rangeObjectUnderTest = new Range(-78, -78);
		assertEquals("getLowerBound: Did not return the expected output", -78.0, rangeObjectUnderTest.getLowerBound(),
				0.000000001d);

	}

	@Test
	public void testGetLowerBoundNullRangeShouldThrowException() {

		rangeObjectUnderTest = null;
		try {
			rangeObjectUnderTest.getLowerBound();
			fail("No exception thrown-Expected outcome was: a thrown exception of type: NullPointerException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(NullPointerException.class));

		}
	}
	//
	//
	// getUpperBound() Tests
	//
	//
	
	@Test
	public void testGetUpperBoundUpperLowerBothPositiveShouldReturnUpper() {
		
		rangeObjectUnderTest = new Range(5, 17);
		assertEquals("getLowerBound: Did not return the expected output",17.0, rangeObjectUnderTest.getUpperBound(),
				0.000000001d);
		
	}
	
	@Test
	public void testGetUpperBoundUpperLowerBothNegativewShouldReturnUpper() {
		
		rangeObjectUnderTest = new Range(-32, -4);
		assertEquals("getLowerBOund: Did not return the expected output",-4.0, rangeObjectUnderTest.getUpperBound(),
				0.000000001d);
		
	}
	
	@Test
	public void testGetUpperBoundLowerNegativeUpperPositiveShouldReturnUpper() {
		
		rangeObjectUnderTest = new Range(-1, 6);
		assertEquals("getLowerBound: Did not return the expected output", 6.0, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
		
	}
	
	@Test
	public void testGetUpperBoundUpperLowerEqualAndPositiveShouldReturnCorrectValue() {
		
		rangeObjectUnderTest = new Range(91, 91);
		assertEquals("getLowerBOund: Did not return the expected output", 91.0, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
		
	}
	
	@Test
	public void testGetUpperBoundUpperLowerEqualAndNegativeShouldReturnCorrectValue() {
		
		rangeObjectUnderTest = new Range(-78, -78);
		assertEquals("getLowerBound: Did not return the expected output", -78.0, rangeObjectUnderTest.getUpperBound(),
				0.000000001d);
		
	}
	
	@Test
	public void testGetUpperBoundNullRangeShouldThrowException() {
		
		rangeObjectUnderTest = null;
		try {
			rangeObjectUnderTest.getUpperBound();
			fail("No exception thrown-Expected outcome was: a thrown exception of type: NullPointerException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(NullPointerException.class));
			
		}
	}
	
	/*
	 * 
	 *  Expand Method Tests 
	 * 
	 *  */
	
	@Test
	public void A_testExpandValidRangeAndMarginsBoth0ShouldReturnUnchangedRange() {
		
		expectedExpandedRange = new Range(-7.5, 12);

		expandRangeObjectUnderTest = Range.expand(expandRangeObjectUnderTest, 0, 0);

		assertEquals("The range returned should be equal to the range input", expectedExpandedRange,
				expandRangeObjectUnderTest);
		assertEquals("The lower boundrange returned should be equal to that of range input",
				expectedExpandedRange.getLowerBound(), expandRangeObjectUnderTest.getLowerBound(), 0.000000001d);
		assertEquals("The length of range returned should be equal to that of range input",
				expectedExpandedRange.getLength(), expandRangeObjectUnderTest.getLength(), 0.000000001d);

	}

	@Test
	public void example_testExpandValidRangeAndMarginsBoth0ShouldReturnUnchangedRange() {
		
		expectedExpandedRange = new Range(1, 8);
		
		expandRangeObjectUnderTest = Range.expand(new Range(2, 6), 0.25, 0.5);

		assertEquals("The range returned should be equal to the range input", expectedExpandedRange,
				expandRangeObjectUnderTest);
		assertEquals("The lower boundrange returned should be equal to that of range input",
				expectedExpandedRange.getLowerBound(), expandRangeObjectUnderTest.getLowerBound(), 0.000000001d);
		assertEquals("The length of range returned should be equal to that of range input",
				expectedExpandedRange.getLength(), expandRangeObjectUnderTest.getLength(), 0.000000001d);

	}

	@Test
	public void B_testExpandValidRangeAndLowerMarginGreaterThanUpperBothPositiveShouldReturnExpectedRange() {
		expectedExpandedRange = new Range(-21.15, 14.925);

		expandRangeObjectUnderTest = Range.expand(expandRangeObjectUnderTest, 0.7, 0.15);

		assertEquals("The range returned should be equal to the expected range", expectedExpandedRange,
				expandRangeObjectUnderTest);
		assertEquals("The lower bound returned should be equal to that of the expected expanded range",
				expectedExpandedRange.getLowerBound(), expandRangeObjectUnderTest.getLowerBound(), 0.000000001d);
		assertEquals("The length of range returned should be equal to that of the expected expanded range",
				expectedExpandedRange.getLength(), expandRangeObjectUnderTest.getLength(), 0.000000001d);

	}

	@Test
	public void C_testExpandValidRangePositiveLowerMarginAndNegativeUpperMarginShouldReturnExpectedRange() {
		expectedExpandedRange = new Range(-17.25, 6.15);
		
		expandRangeObjectUnderTest = Range.expand(expandRangeObjectUnderTest, 0.5, -0.3);
		
		assertEquals("The range returned should be equal to the expected expanded range", expectedExpandedRange,
				expandRangeObjectUnderTest);
		assertEquals("The lower bound returned should be equal to that of the expected expanded range",
				expectedExpandedRange.getLowerBound(), expandRangeObjectUnderTest.getLowerBound(), 0.000000001d);
		assertEquals("The length of range returned should be equal to that of the expected expanded range",
				expectedExpandedRange.getLength(), expandRangeObjectUnderTest.getLength(), 0.000000001d);

	}

	@Test
	public void D_testExpandValidRangeAndLowerMarginGreaterThanUpperBothNegativeShouldThrowException() {

		try {
			expandRangeObjectUnderTest = Range.expand(expandRangeObjectUnderTest, -0.4, -0.8);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));

		}

	}

	@Test
	public void E_testExpandValidRangeAndUpperMarginGreaterThanLowerBothNegativeShouldThrowException() {
		try {
			expandRangeObjectUnderTest = Range.expand(expandRangeObjectUnderTest, -0.75, -0.25);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));

		}

	}

	@Test
	public void F_testExpandValidRangeAndUpperMarginGreaterThanLowerBothPositiveShouldReturnExpectedRange() {
		expectedExpandedRange = new Range(-12.375, 26.625);
		expandRangeObjectUnderTest = Range.expand(expandRangeObjectUnderTest, 0.25, 0.75);

		assertEquals("The range returned should be equal to the range input", expectedExpandedRange,
				expandRangeObjectUnderTest);
		assertEquals("The lower bound returned should be equal to that of the expected expanded range",
				expectedExpandedRange.getLowerBound(), expandRangeObjectUnderTest.getLowerBound(), 0.000000001d);
		assertEquals("The length of range returned should be equal to that of the expected expanded range",
				expectedExpandedRange.getLength(), expandRangeObjectUnderTest.getLength(), 0.000000001d);

	}

	@Test
	public void F2_testExpandInvalidNullRangeAndUpperMarginGreaterThanLowerBothPositiveShouldThrowExpectedException() {

		try {
			expandRangeObjectUnderTest = Range.expand(null, 0.25, 0.75);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}

}
