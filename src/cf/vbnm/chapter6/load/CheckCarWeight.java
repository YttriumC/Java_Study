package cf.vbnm.chapter6.load;

interface ComputerWeight {
	double computeWeight();
}

class Television implements ComputerWeight {
	@Override
	public double computeWeight() {
		return 3.5;
	}
}

class Computer implements ComputerWeight {
	@Override
	public double computeWeight() {
		return 14.5;
	}
}

class WashMachine implements ComputerWeight {
	@Override
	public double computeWeight() {
		return 35.6;
	}
}

class Truck {
	private ComputerWeight[] goods;
	private double totalWeights = 0;

	Truck(ComputerWeight[] goods) {
		this.goods = goods;
	}

	public void setGoods(ComputerWeight[] goods) {
		this.goods = goods;
	}

	public double getTotalWeights() {
		totalWeights = 0;
		for (int i = 0; i < goods.length; i++) {
			totalWeights += goods[i].computeWeight();
		}
		return totalWeights;
	}
}


public class CheckCarWeight {
	public static void main(String[] args) {
		ComputerWeight[] goods = new ComputerWeight[650];
		for (int i = 0; i < goods.length; i++) {
			if (i % 3 == 0) {
				goods[i] = new Television();
			} else if (i % 3 == 1) {
				goods[i] = new Computer();
			} else {
				goods[i] = new WashMachine();
			}
		}
		Truck truck = new Truck(goods);
		System.out.printf("货车装载的货物重量:%-8.3f kg\n", truck.getTotalWeights());
		goods = new ComputerWeight[68];
		for (int i = 0; i < goods.length; i++) {
			if (i % 2 == 0)
				goods[i] = new Television();
			else
				goods[i] = new WashMachine();
		}
		truck.setGoods(goods);
		System.out.printf("\n货车装载的货物重量:%-8.3f kg\n", truck.getTotalWeights());
	}
}
