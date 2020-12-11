package cf.vbnm.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Robot {
	//行列全局变量
	static int row, column;
	//初始距离,最大数值,在第一次找到路径被修改
	static int distance = Integer.MAX_VALUE;
	//一个保存路径的可变数组
	static ArrayList<Path> path = new ArrayList<>();
	//终点(出口)
	static Path end;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//先输入行
		row = sc.nextInt();
		//再输入列
		column = sc.nextInt();
		//地图数据数组
		byte[][] input = new byte[row][column];
		//定义出口
		end = new Path(row - 1, column - 1);
		//获取数据
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				input[i][j] = sc.nextByte();
			}
		}

		/*开始搜索路径:DFS
		 * @param input 地图数据
		 * @param 0 当前距离
		 * @param new Path(0, 0) 当前搜索点,从这个点开始搜索
		 * */
		search(input, 0, new Path(0, 0));
		System.out.println(distance);
	}
	/**
	 * @param map 地图数据
	 * @param distance 当前走过的距离
	 * @param path 当前的位置,从这个位置搜索
	 * */
	public static void search(byte[][] map, int distance, Path path) {
		//如果是终点,就比较距离,取最小的存储
		if (end.equals(path)) {
			Robot.distance = Math.min(Robot.distance, distance);
			return;
		}
		//判断是否曾经来过这个点,避免死循环
		if (haveBeen(path))
			return;
		//判断是否可以向上走,下同
		if (path.canUp(map)) {
			//向上走几格(是否翻越障碍)
			if (map[path.getRow() - 1][path.getColumn()] == 1) {
				//走2格
				//存储路径,下同
				Robot.path.add(path);
				//从下一点开始搜索,下同
				search(map, distance + 2, new Path(path.getRow() - 2, path.getColumn()));
				//搜索完毕,移除路径
				Robot.path.remove(Robot.path.size() - 1);
			} else {
				//走1格,下同,下同
				Robot.path.add(path);
				search(map, distance + 1, new Path(path.getRow() - 1, path.getColumn()));
				Robot.path.remove(Robot.path.size() - 1);
			}
		}
		//是否可以向右走
		if (path.canRight(map)) {
			if (map[path.getRow()][path.getColumn() + 1] == 1) {
				Robot.path.add(path);
				search(map, distance + 2, new Path(path.getRow(), path.getColumn() + 2));
				Robot.path.remove(Robot.path.size() - 1);
			} else {
				Robot.path.add(path);
				search(map, distance + 1, new Path(path.getRow(), path.getColumn() + 1));
				Robot.path.remove(Robot.path.size() - 1);
			}
		}
		//左
		if (path.canLeft(map)) {
			if (map[path.getRow()][path.getColumn() - 1] == 1) {
				Robot.path.add(path);
				search(map, distance + 2, new Path(path.getRow(), path.getColumn() - 2));
				Robot.path.remove(Robot.path.size() - 1);
			} else {
				Robot.path.add(path);
				search(map, distance + 1, new Path(path.getRow(), path.getColumn() - 1));
				Robot.path.remove(Robot.path.size() - 1);
			}
		}
		//下
		if (path.canDown(map)) {
			if (map[path.getRow() + 1][path.getColumn()] == 1) {
				Robot.path.add(path);
				search(map, distance + 2, new Path(path.getRow() + 2, path.getColumn()));
				Robot.path.remove(Robot.path.size() - 1);
			} else {
				Robot.path.add(path);
				search(map, distance + 1, new Path(path.getRow() + 1, path.getColumn()));
				Robot.path.remove(Robot.path.size() - 1);
			}
		}

	}

	/**
	 * 判断是否走过这个位置
	 * @param p 位置
	 * */
	public static boolean haveBeen(Path p) {
		for (Path value : path)
			if (value.equals(p))
				return true;
		return false;
	}
}

class Path {
	//行
	private int row;
	//列
	private int column;

	/**
	 * 判断参数与本身是不是同一个位置
	 * @param o 判断的参数
	 * */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Path path = (Path) o;
		return row == path.row && column == path.column;
	}

	/**
	 * 能不能向上走,下同,下同
	 * @param map 地图数据
	 * */
	public boolean canUp(byte[][] map) {
		//如果是第一行,false
		if (row == 0)
			return false;
		//如果是第二行,第一行为0,true
		if (row == 1 && map[0][column] == 0)
			return true;
		//超过2行
		if (row > 1)
			//判断上一行是不是1
			if (map[row - 1][column] == 1)
				//是1,返回上上一行是不是1
				return map[row - 2][column] != 1;
			else
				//上一行不是一,true
				return true;
		//都不匹配,false
		return false;
	}
	/**
	 * 能不能向下走,下同,下同
	 * */
	public boolean canDown(byte[][] map) {
		if (row == Robot.row - 1)
			return false;
		if (row == Robot.row - 2 && map[Robot.row - 1][column] == 0)
			return true;
		if (row < Robot.row - 2)
			if (map[row + 1][column] == 1)
				return map[row + 2][column] != 1;
			else
				return true;
		return false;
	}

	public boolean canLeft(byte[][] map) {
		if (column == 0)
			return false;
		if (column == 1 && map[row][0] == 0)
			return true;
		if (column > 1)
			if (map[row][column - 1] == 1)
				return map[row][column - 2] != 1;
			else
				return true;
		return false;
	}

	public boolean canRight(byte[][] map) {
		if (column == Robot.column - 1)
			return false;
		if (column == Robot.column - 2 && map[row][Robot.column - 1] == 0)
			return true;
		if (column < Robot.column - 2)
			if (map[row][column + 1] == 1)
				return map[row][column + 2] != 1;
			else
				return true;
		return false;
	}

	public Path(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
}
