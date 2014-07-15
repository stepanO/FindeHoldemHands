package Home;

import java.util.ArrayList;
import java.util.List;


public class Definition {

	public static String findCombination(Map[] maps) {
		
		ArrayList<Map> tempMap = new ArrayList<Map>();
		int sameStrenght = 0;
		int countPair = 0;
		int color = 0;
		int order = 0;
		int mapIsKiker = mapIsKiker(maps);
		String result;

		int[] mapIsPairSetKare = mapIsPairSetKare(maps);
		boolean mapIsStreet = mapIsStreet(maps);
		boolean mapIsFlash = mapIsFlash(maps);

		if (mapIsFlash(maps) && mapIsStreet && mapIsKiker == 0) {
			result = "Флэшь-рояль";
			order = 10;
		} else if (mapIsFlash && mapIsStreet) {
			order = 9;
			return "Стрит-флеш";
		} else if (mapIsPairSetKare[0] == 4 && mapIsPairSetKare[1] == 1) {
			order = 8;
			return "Каре";
		} else if (mapIsPairSetKare[0] == 5 && mapIsPairSetKare[1] == 2) {
			order = 7;
			return "Фулл хаус";
		} else if (mapIsFlash) {
			order = 6;
			return "Флеш";
		} else if (mapIsStreet && mapIsPairSetKare[1] == 0) {
			order = 5;
			return "Стрит";
		} else if (mapIsPairSetKare[0] == 3 && mapIsPairSetKare[1] == 1) {
			order = 4;
			return "Сет";
		} else if (mapIsPairSetKare[0] == 2 && mapIsPairSetKare[1] == 1) {
			order = 3;
			return "Пара";
		} else if (mapIsPairSetKare[0] == 1 && mapIsPairSetKare[1] == 0) {
			order = 2;
			return "Старшая карта";
		}
		return "Не найдено комбинаций. Видимо это ошибка, попробуйте ещё раз";

	}

	static boolean mapIsFlash(Map[] map) {
		int countColor = 1;
		for (int i = 0; i < map.length; i++) {
			if (map[0]._color != map[i]._color) {
				countColor++;
				break;
			}
		}
		return countColor == 1 ? true : false;
	}

	static boolean mapIsStreet(Map[] map) {
		int min = 100; // 100 нереальное значение
		int max = 0;
		for (int i = 0; i < map.length; i++) {
			if (map[i]._strenght < min) {
				min = map[i]._strenght;
			} else {
				max = map[i]._strenght;
			}
		}
		return max - min == 4 ? true : false;
	}

	/*static int[] mapIsPairSetKare(Map[] map) {
		Map[] map2 = map;
		map = sort(map);
		for (Map s : map) {
			System.out.println(s);
		}
		int count = 0;
		int pair = 0;
		int strenght = 100;
		int[] strenght2 = new int[map.length];
		boolean fix = false;

		for (int i = 0, x = 0; i < map.length; i++) {
			// находим пары, сеты, каре
			if (map[i]._strenght != strenght && strenght == 100) {
				strenght = map[i]._strenght;
			} else if (strenght == map[i]._strenght) {
				if (!fix) {count++;fix = true;}
				count++;
				pair++;
			} else {strenght2[x] = map[i]._strenght; x++;}

		}
		
		for (int str : strenght2) {
			if (str == )
		}
		return new int[] { count, pair/2};
	}*/

	static int[] mapIsPairSetKare(Map[] map) {
		List<Integer> listMap= new ArrayList<>();
		for(int i =0; i< map.length; i++) {
			listMap.add(map[i]._strenght);
		}
		Map[] map2 = map;
		Integer temp;
		int count = 0;
		int pair = 0;
		int strenght = 100;
		
		for (int i = 0; i < map.length; i++) {
			temp = listMap.get(i);
			listMap.remove(i);
			if (listMap.contains(temp)) {
				if (count == 0) count += 2; else count++;
				pair++;
			}
		}
		return new int[]{count,pair};
	}
	
	static int mapIsKiker(Map[] map) {
		int result = -1;
		for (int i = 0; i < map.length; i++) {
			if (map[i]._strenght > result) {
				result = map[i]._strenght;
			} else {

			}
		}
		return result;
	}
	
	static Map[] sort(Map[] map) {
		Map tempMap;
		for (int i = 0; i < map.length-1; i++) {
			for(int x = 0; x < map.length - 1; x++) {
				if (map[i]._strenght < map[x]._strenght) {
					tempMap = map[i];
					map[i] = map[x];
					map[x] = tempMap;
				}
			}
		}
		return map;
	}

	public static void main(String[] args) {
		System.out.println( "sss" + Math.round(1.5));
		System.out.println( "sss" + Math.round(15/10));
		// System.out.println("mapIsFlash " + mapIsFlash(new Map[]{new
		// Map(0,0),new Map(1,0),new Map(2,0),new Map(3,0),new Map(4,0)}));
		// System.out.println(mapIsPairSetKare(new Map[]{new Map(0,0),new
		// Map(1,0),new Map(2,0),new Map(3,0),new Map(4,0)})[0]);
		// System.out.println(mapIsPairSetKare(new Map[]{new Map(0,0),new
		// Map(1,0),new Map(2,0),new Map(3,0),new Map(4,0)})[1]);
		// System.out.println(findCombination(new Map[]{new Map(0,0),new
		// Map(1,0),new Map(2,0),new Map(3,0),new Map(4,0)}));
	}

}
