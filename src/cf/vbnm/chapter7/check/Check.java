package cf.vbnm.chapter7.check;

public class Check {
	public static void main(String[] args) {
		Machine machine = new Machine();
		String name[] = {"apple", "boom", "suit", "H2SO4", "watch", "S"};
		Goods[] goods = new Goods[name.length];
		for (int i = 0; i < name.length; i++) {
			goods[i] = new Goods();
			if (i % 2 == 0) {
				goods[i].setIsDanger(false);
			}else {
				goods[i].setIsDanger(true);
			}
			goods[i].setName(name[i]);
		}
		for (int i = 0; i < goods.length; i++) {
			try {
				machine.checkBag(goods[i]);

			}catch (DangerException e){
				e.toShow();
				System.out.println(goods[i].getName()+"被禁止!");
			}
		}
	}
}
