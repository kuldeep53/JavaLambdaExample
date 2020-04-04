import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lambda {

	public static void main(String[] args) {
		Lambda lambda = new Lambda();
		List<Map<String, String>> list = lambda.inputData();
//		lambda.objectOrient(list);
		lambda.funtionalProgramming(list);
	}

	public void funtionalProgramming(List<Map<String, String>> list) {
		Collections.sort(list, (map1, map2) -> map1.get("firstName").compareTo(map2.get("firstName")));
		System.out.println("======sorted=======================");
		print(list, map -> true);
		System.out.println("======firstName=======================");
		print(list, map -> map.get("firstName").startsWith("k"));
		System.out.println("======lastName=======================");
		print(list, map -> map.get("lastName").startsWith("j"));
	}

	public void objectOrient(List<Map<String, String>> list) {
		Collections.sort(list, new Comparator<Map<String, String>>() {
			@Override
			public int compare(Map<String, String> map1, Map<String, String> map2) {
				return map1.get("firstName").compareTo(map2.get("firstName"));
			}
		});
		print(list, new common() {
			@Override
			public boolean printCondition(Map<String, String> map) {
				return true;
			}
		});
		System.out.println("======sorted=======================");
		print(list, new common() {
			@Override
			public boolean printCondition(Map<String, String> map) {
				return map.get("firstName").startsWith("k");
			}
		});
		System.out.println("======firstName=======================");
		print(list, new common() {
			@Override
			public boolean printCondition(Map<String, String> map) {
				return map.get("lastName").startsWith("j");
			}
		});
		System.out.println("======lastName=======================");

	}

	public List<Map<String, String>> inputData() {
		Map<String, String> map = new HashMap<>();
		List<Map<String, String>> list = new ArrayList<>();
		map.put("firstName", "kuldeep");
		map.put("lastName", "vaishnav");
		list.add(map);
		map = new HashMap<>();
		map.put("firstName", "mukesh");
		map.put("lastName", "meghwal");
		list.add(map);
		map = new HashMap<>();
		map.put("firstName", "nikhil");
		map.put("lastName", "jain");
		list.add(map);
		map = new HashMap<>();
		map.put("firstName", "chandrika");
		map.put("lastName", "solanki");
		list.add(map);
		map = new HashMap<>();
		map.put("firstName", "mukhul");
		map.put("lastName", "bhati");
		list.add(map);
		return list;
	}

	public void print(List<Map<String, String>> list, common common) {
		for (Map<String, String> map : list) {
			if (common.printCondition(map))
				System.out.println("[" + map.get("firstName") + "--->" + map.get("lastName") + "]");
		}
	}

}
