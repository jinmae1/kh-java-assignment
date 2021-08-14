package com.collection.set.cart;

import java.util.*;

public class CartMain {

	private Set<Cart> cart;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		CartMain main = new CartMain();
		main.cart = new HashSet<Cart>();

		while (true) {

			System.out.println("===== 장바구니 =====");
			System.out.println("1. 과일 담기");
			System.out.println("2. 과일 조회");
			System.out.println("3. 전체 조회");
			System.out.println("0. 종료");
			System.out.println("===================");

			System.out.print("> 메뉴 입력: ");

			switch (sc.nextInt()) {
				case 1:
					addToCart(main.cart);
					break;
				case 2:
					searchCart(main.cart);
					break;
				case 3:
					showCart(main.cart);
					break;
				case 0:
					return;

				default:
					System.out.println("잘못 입력하셨습니다.");
					break;
			}

		}

	}

	private static void addToCart(Set<Cart> cart) {
		String fruitName;
		int count;

		while (true) {

			System.out.print("> 과일 입력: ");
			fruitName = sc.next();
			if ("exit".equals(fruitName))
				break;

			if (cart.contains(new Cart(fruitName))) {
				System.out.println("이미 등록된 상품입니다.");
				System.out.println("다시 입력하세요");
			} else {
				while (true) {
				System.out.print("> 수량 입력: ");
				count = sc.nextInt();
				if (count > 0)
					break;
				System.out.println("+++ 0 이하 입력 금지 +++ ");
			}
			cart.add(new Cart(fruitName, count));

				System.out.println("+++++ 입력 완료 +++++\n");
				System.out.println("계속 입력하세요");
			}
		}
	}

	private static void searchCart(Set<Cart> cart) {
		String fruitName;

		System.out.print("> 과일 입력: ");
		fruitName = sc.next();

		for (Cart fruit : cart) {
			if (fruit.equals(new Cart(fruitName)))
				System.out.println(fruit.getCount() + "개가 담겨있습니다.");

		}
	}

	private static void showCart(Set<Cart> cart) {
		List<Cart> cartList = new ArrayList<>(cart);
		Collections.sort(cartList);
		int total = 0;

		int i = 0;
		for (Cart fruit : cartList) {
			System.out.println(++i + ". " + fruit);
			total += fruit.getCount();
		}
		System.out.println("-----------------------------");
		System.out.println("총 " + total + "개의 상품이 담겨있습니다.");
	}

	private static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}