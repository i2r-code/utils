package net.i2r.utils.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for {@link ToJsonStringUtils}.
 *
 * @author rkapushchak
 */
public final class ToJsonStringUtilsTest {

	private static final Integer intValue = 1;
	private static final Float floatValue = 2F;
	private static final Double doubleValue = 3D;
	private static final Long longValue = 4L;
	private static final Boolean boolValue = true;
	private static final String stringValue = "str";
	private static final Integer[] intArray = {1};
	private static final Float[] floatArray = {1F, 2F};
	private static final Double[] doubleArray = {1D, 2D, 3D};
	private static final Long[] longArray = {1L, 2L, 3L, 4L};
	private static final Boolean[] boolArray = {true, false, true};
	private static final String[] stringArray = {"str1", "str2"};
	private static final List<Integer> intList = Stream.of(1).collect(Collectors.toList());
	private static final List<Float> floatList = Stream.of(1F, 2F).collect(Collectors.toList());
	private static final List<Double> doubleList = Stream.of(1D, 2D, 3D).collect(Collectors.toList());
	private static final List<Long> longList = Stream.of(1L, 2L, 3L, 4L).collect(Collectors.toList());
	private static final List<Boolean> boolList = Stream.of(true, false, true).collect(Collectors.toList());
	private static final List<String> stringList = Stream.of("str1", "str2").collect(Collectors.toList());
	private static final Set<Integer> intSet = Stream.of(1).collect(Collectors.toSet());
	private static final Set<Float> floatSet = Stream.of(1F, 2F).collect(Collectors.toSet());
	private static final Set<Double> doubleSet = Stream.of(1D, 2D, 3D).collect(Collectors.toSet());
	private static final Set<Long> longSet = Stream.of(1L, 2L, 3L, 4L).collect(Collectors.toSet());
	private static final Set<Boolean> boolSet = Stream.of(true, false).collect(Collectors.toSet());
	private static final Set<String> stringSet = Stream.of("str1", "str2").collect(Collectors.toSet());
	private static final Map<String, Integer> integerMap = new HashMap<>();
	private static final Map<String, Float> floatMap = new HashMap<>();
	private static final Map<String, Double> doubleMap = new HashMap<>();
	private static final Map<String, Long> longMap = new HashMap<>();
	private static final Map<String, Boolean> boolMap = new HashMap<>();
	private static final Map<String, String> strMap = new HashMap<>();

	static {
		integerMap.put("field1", 1);
		integerMap.put("field2", 2);
		floatMap.put("field1", 1F);
		floatMap.put("field2", 2F);
		doubleMap.put("field1", 1D);
		doubleMap.put("field2", 2D);
		longMap.put("field1", 1L);
		longMap.put("field2", 2L);
		boolMap.put("field1", true);
		boolMap.put("field2", false);
		strMap.put("field1", "str1");
		strMap.put("field2", "str2");
	}

	static class ToTest {
		int intField = 1;
		float floatField = 2F;
		double doubleField = 3D;
		long longField = 4L;
		Boolean boolField = true;
		String stringField = "str";
		Integer[] intArray = {1};
		Float[] floatArray = {1F, 2F};
		Double[] doubleArray = {1D, 2D, 3D};
		Long[] longArray = {1L, 2L, 3L, 4L};
		Boolean[] boolArray = {true, false, true};
		String[] stringArray = {"str1", "str2"};
		List<Integer> intList = Stream.of(1).collect(Collectors.toList());
		List<Float> floatList = Stream.of(1F, 2F).collect(Collectors.toList());
		List<Double> doubleList = Stream.of(1D, 2D, 3D).collect(Collectors.toList());
		List<Long> longList = Stream.of(1L, 2L, 3L, 4L).collect(Collectors.toList());
		List<Boolean> boolList = Stream.of(true, false, true).collect(Collectors.toList());
		List<String> stringList = Stream.of("str1", "str2").collect(Collectors.toList());
		Set<Integer> intSet = Stream.of(1).collect(Collectors.toSet());
		Set<Float> floatSet = Stream.of(1F, 2F).collect(Collectors.toSet());
		Set<Double> doubleSet = Stream.of(1D, 2D, 3D).collect(Collectors.toSet());
		Set<Long> longSet = Stream.of(1L, 2L, 3L, 4L).collect(Collectors.toSet());
		Set<Boolean> boolSet = Stream.of(true, false).collect(Collectors.toSet());
		Set<String> stringSet = Stream.of("str1", "str2").collect(Collectors.toSet());
		Map<String, Integer> integerMap = new HashMap<>();
		Map<String, Float> floatMap = new HashMap<>();
		Map<String, Double> doubleMap = new HashMap<>();
		Map<String, Long> longMap = new HashMap<>();
		Map<String, Boolean> boolMap = new HashMap<>();
		Map<String, String> strMap = new HashMap<>();

		public ToTest() {
			this.integerMap.put("field1", 1);
			this.integerMap.put("field2", 2);
			this.floatMap.put("field1", 1F);
			this.floatMap.put("field2", 2F);
			this.doubleMap.put("field1", 1D);
			this.doubleMap.put("field2", 2D);
			this.longMap.put("field1", 1L);
			this.longMap.put("field2", 2L);
			this.boolMap.put("field1", true);
			this.boolMap.put("field2", false);
			this.strMap.put("field1", "str1");
			this.strMap.put("field2", "str2");
		}
	}

	private static final String intValueStr = intValue.toString();
	private static final String floatValueStr = floatValue.toString();
	private static final String doubleValueStr = doubleValue.toString();
	private static final String longValueStr = longValue.toString();
	private static final String boolValueStr = boolValue.toString();
	private static final String stringValueStr = "\"" + stringValue + "\"";
	private static final String intArrayStr = "[1]";
	private static final String floatArrayStr = "[1.0,2.0]";
	private static final String doubleArrayStr = "[1.0,2.0,3.0]";
	private static final String longArrayStr = "[1,2,3,4]";
	private static final String boolArrayStr = "[true,false,true]";
	private static final String stringArrayStr = "[\"str1\",\"str2\"]";
	private static final String intListStr = "[1]";
	private static final String floatListStr = "[1.0,2.0]";
	private static final String doubleListStr = "[1.0,2.0,3.0]";
	private static final String longListStr = "[1,2,3,4]";
	private static final String boolListStr = "[true,false,true]";
	private static final String stringListStr = "[\"str1\",\"str2\"]";
	private static final String intSetStr = "[1]";
	private static final String floatSetStr = "[1.0,2.0]";
	private static final String doubleSetStr = "[1.0,2.0,3.0]";
	private static final String longSetStr = "[1,2,3,4]";
	private static final String boolSetStr = "[false,true]";
	private static final String stringSetStr = "[\"str1\",\"str2\"]";
	private static final String intMapStr = "{\"field1\":1,\"field2\":2}";
	private static final String floatMapStr = "{\"field1\":1.0,\"field2\":2.0}";
	private static final String doubleMapStr = "{\"field1\":1.0,\"field2\":2.0}";
	private static final String longMapStr = "{\"field1\":1,\"field2\":2}";
	private static final String boolMapStr = "{\"field1\":true,\"field2\":false}";
	private static final String strMapStr = "{\"field1\":\"str1\",\"field2\":\"str2\"}";

	@Test
	public void contextIsNotInitialized() {
		Assert.assertEquals(intValueStr, ToJsonStringUtils.toString(intValue));
		Assert.assertEquals(floatValueStr, ToJsonStringUtils.toString(floatValue));
		Assert.assertEquals(doubleValueStr, ToJsonStringUtils.toString(doubleValue));
		Assert.assertEquals(longValueStr, ToJsonStringUtils.toString(longValue));
		Assert.assertEquals(boolValueStr, ToJsonStringUtils.toString(boolValue));
		Assert.assertEquals(stringValueStr, ToJsonStringUtils.toString(stringValue));
		Assert.assertEquals(intArrayStr, ToJsonStringUtils.toString(intArray));
		Assert.assertEquals(floatArrayStr, ToJsonStringUtils.toString(floatArray));
		Assert.assertEquals(doubleArrayStr, ToJsonStringUtils.toString(doubleArray));
		Assert.assertEquals(longArrayStr, ToJsonStringUtils.toString(longArray));
		Assert.assertEquals(boolArrayStr, ToJsonStringUtils.toString(boolArray));
		Assert.assertEquals(stringArrayStr, ToJsonStringUtils.toString(stringArray));
		Assert.assertEquals(intListStr, ToJsonStringUtils.toString(intList));
		Assert.assertEquals(floatListStr, ToJsonStringUtils.toString(floatList));
		Assert.assertEquals(doubleListStr, ToJsonStringUtils.toString(doubleList));
		Assert.assertEquals(longListStr, ToJsonStringUtils.toString(longList));
		Assert.assertEquals(boolListStr, ToJsonStringUtils.toString(boolList));
		Assert.assertEquals(stringListStr, ToJsonStringUtils.toString(stringList));
		Assert.assertEquals(intSetStr, ToJsonStringUtils.toString(intSet));
		Assert.assertEquals(floatSetStr, ToJsonStringUtils.toString(floatSet));
		Assert.assertEquals(doubleSetStr, ToJsonStringUtils.toString(doubleSet));
		Assert.assertEquals(longSetStr, ToJsonStringUtils.toString(longSet));
		Assert.assertEquals(boolSetStr, ToJsonStringUtils.toString(boolSet));
		Assert.assertEquals(stringSetStr, ToJsonStringUtils.toString(stringSet));
		Assert.assertEquals(intMapStr, ToJsonStringUtils.toString(integerMap));
		Assert.assertEquals(floatMapStr, ToJsonStringUtils.toString(floatMap));
		Assert.assertEquals(doubleMapStr, ToJsonStringUtils.toString(doubleMap));
		Assert.assertEquals(longMapStr, ToJsonStringUtils.toString(longMap));
		Assert.assertEquals(boolMapStr, ToJsonStringUtils.toString(boolMap));
		Assert.assertEquals(strMapStr, ToJsonStringUtils.toString(strMap));

		StringBuilder sb = new StringBuilder().append("{");
		sb.append("\"intField\":").append(intValueStr).append(",");
		sb.append("\"floatField\":").append(floatValueStr).append(",");
		sb.append("\"doubleField\":").append(doubleValueStr).append(",");
		sb.append("\"longField\":").append(longValueStr).append(",");
		sb.append("\"boolField\":").append(boolValueStr).append(",");
		sb.append("\"stringField\":").append(stringValueStr).append(",");
		sb.append("\"intArray\":").append(intArrayStr).append(",");
		sb.append("\"floatArray\":").append(floatArrayStr).append(",");
		sb.append("\"doubleArray\":").append(doubleArrayStr).append(",");
		sb.append("\"longArray\":").append(longArrayStr).append(",");
		sb.append("\"boolArray\":").append(boolArrayStr).append(",");
		sb.append("\"stringArray\":").append(stringArrayStr).append(",");
		sb.append("\"intList\":").append(intListStr).append(",");
		sb.append("\"floatList\":").append(floatListStr).append(",");
		sb.append("\"doubleList\":").append(doubleListStr).append(",");
		sb.append("\"longList\":").append(longListStr).append(",");
		sb.append("\"boolList\":").append(boolListStr).append(",");
		sb.append("\"stringList\":").append(stringListStr).append(",");
		sb.append("\"intSet\":").append(intSetStr).append(",");
		sb.append("\"floatSet\":").append(floatSetStr).append(",");
		sb.append("\"doubleSet\":").append(doubleSetStr).append(",");
		sb.append("\"longSet\":").append(longSetStr).append(",");
		sb.append("\"boolSet\":").append(boolSetStr).append(",");
		sb.append("\"stringSet\":").append(stringSetStr).append(",");
		sb.append("\"integerMap\":").append(intMapStr).append(",");
		sb.append("\"floatMap\":").append(floatMapStr).append(",");
		sb.append("\"doubleMap\":").append(doubleMapStr).append(",");
		sb.append("\"longMap\":").append(longMapStr).append(",");
		sb.append("\"boolMap\":").append(boolMapStr).append(",");
		sb.append("\"strMap\":").append(strMapStr);
		sb.append("}");

		Assert.assertEquals(sb.toString(), ToJsonStringUtils.toString(new ToTest()));

		final ToTest[] toTestArray = new ToTest[2];
		toTestArray[0] = new ToTest();
		toTestArray[1] = new ToTest();

		final String toTestArrayStr = "[" + sb.toString() + "," + sb.toString() + "]";
		Assert.assertEquals(toTestArrayStr, ToJsonStringUtils.toString(toTestArray));

		final List<ToTest> toTestList = new ArrayList<>();
		toTestList.add(new ToTest());
		toTestList.add(new ToTest());

		final String toTestListStr = "[" + sb.toString() + "," + sb.toString() + "]";
		Assert.assertEquals(toTestListStr, ToJsonStringUtils.toString(toTestList));

		final Set<ToTest> toTestSet = new HashSet<>();
		toTestSet.add(new ToTest());
		toTestSet.add(new ToTest());

		final String toSetListStr = "[" + sb.toString() + "," + sb.toString() + "]";
		Assert.assertEquals(toSetListStr, ToJsonStringUtils.toString(toTestSet));

		final Map<String, ToTest> toTestMap = new HashMap<>();
		toTestMap.put("key1", new ToTest());
		toTestMap.put("key2", new ToTest());

		final String toTestMapStr = "{\"key1\":"+sb.toString()+",\"key2\":"+sb.toString()+"}";
		Assert.assertEquals(toTestMapStr, ToJsonStringUtils.toString(toTestMap));
	}
}
