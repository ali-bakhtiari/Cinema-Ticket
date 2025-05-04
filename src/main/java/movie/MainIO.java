package movie;

import lombok.var;

import java.util.Scanner;

public class MainIO {
    public static void main(String[] args) {
        System.out.println("AZADI CINEMA");
        MovieLogic movieLogic = new MovieLogic();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("لیست فیلم‌ها:");
            var movies = movieLogic.getAllFilms();
            for (int i = 0; i < movies.size(); i++) {
                Film m = movies.get(i);
                System.out.printf("%d. %s - بلیط موجود %d  - قیمت $ %.2f\n",
                        i + 1, m.getName(), m.getNumberTicketAvailable(), m.getPrice());
            }
            System.out.print("شماره فیلم:");
            int entry = scanner.nextInt();
            if (entry == 0) {
                System.out.println("شماره فیلم ها از 1 شروع میشود");
                break;
            }
            Film selected = movieLogic.getChoosenFilm(entry);
            if (selected == null) {
                System.out.println("فیلمی با این مشخصات نیست.");
                continue;
            }
            System.out.print("تعداد بلیط:");
            int count = scanner.nextInt();

            if (count <= 0) {
                System.out.println("تعداد وارد شده معتبر نیست.");
                continue;
        }
            if (movieLogic.buyingTicket(selected, count)) {
                double total = count * selected.getPrice();
                System.out.printf("خرید موفق. مبلغ کل: %.2f$\n", total);
            } else {
                System.out.println("بلیط کافی موجود نیست.");
            }
        }
    }
    }

