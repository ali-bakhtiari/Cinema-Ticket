package movie;
import model.Film;
import repository.MovieRepository;
import service.IMovieService;
import service.MovieService;

import java.util.List;
import java.util.Scanner;

public class MainIO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IMovieService service = new MovieService(new MovieRepository());
        while (true) {
            System.out.println("\n منو- سینما آزادی ");
            System.out.println("1. نمایش فیلم‌ها");
            System.out.println("2. خرید بلیط");
            System.out.println("3. افزودن فیلم");
            System.out.println("4. ویرایش فیلم");
            System.out.println("5. حذف فیلم");
            System.out.println("0. خروج");
            System.out.print("انتخاب شما: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    List<Film> films = service.getAllFilms();
                    for (Film f : films) {
                        System.out.printf("%d. %s - بلیط موجود %d  - قیمت $ %.2f\n",
                                f.getId(), f.getName(), f.getNumberTicketAvailable(), f.getPrice());
                    }
                    break;

                case 2:
                    System.out.print("شناسه فیلم: ");
                    int id = scanner.nextInt();
                    System.out.print("تعداد بلیط: ");
                    int count = scanner.nextInt();
                    if (service.buyTicket(id, count)) {
                        double total = service.getFilm(id).getPrice() * count;
                        System.out.printf(" خرید موفق - مبلغ کل: %.2f$\n", total);
                    } else {
                        System.out.println(" بلیط کافی نیست یا فیلم پیدا نشد.");
                    }
                    break;

                case 3:
                    System.out.print("نام فیلم: ");
                    String name = scanner.nextLine();
                    System.out.print("تعداد بلیط: ");
                    int ticketCount = scanner.nextInt();
                    System.out.print("قیمت: ");
                    double price = scanner.nextDouble();
                    service.addFilm(new Film(0, name, ticketCount, price));
                    System.out.println(" فیلم اضافه شد.");
                    break;

                case 4:
                    System.out.print("شناسه فیلم برای ویرایش: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("نام جدید: ");
                    String newName = scanner.nextLine();
                    System.out.print("تعداد جدید بلیط: ");
                    int newCount = scanner.nextInt();
                    System.out.print("قیمت جدید: ");
                    double newPrice = scanner.nextDouble();
                    boolean updated = service.updateFilm(updateId, new Film(0, newName, newCount, newPrice));
                    System.out.println(updated ? " فیلم ویرایش شد." : " فیلم پیدا نشد.");
                    break;

                case 5:
                    System.out.print("شناسه فیلم برای حذف: ");
                    int deleteId = scanner.nextInt();
                    service.deleteFilm(deleteId);
                    System.out.println(" حذف شد. ");
                    break;

                case 0:
                    System.out.println("تا دیدار بعد خدانگهدار");
                    return;

                default:
                    System.out.println(" گزینه نامعتبر.");
            }
        }
    }
}
//            System.out.println("لیست فیلم‌ها:");
//            List<Film> movies = movieLogic.getAllFilms();
//            for (int i = 0; i < movies.size(); i++) {
//                Film m = movies.get(i);
//                System.out.printf("%d. %s - بلیط موجود %d  - قیمت $ %.2f\n",
//                        i + 1, m.getName(), m.getNumberTicketAvailable(), m.getPrice());
//            }
//            System.out.print("شماره فیلم:");
//            int entry = scanner.nextInt();
//            if (entry == 0) {
//                System.out.println("شماره فیلم ها از 1 شروع میشود");
//                break;
//            }
//            Film selected = movieLogic.getChoosenFilm(entry);
//            if (selected == null) {
//                System.out.println("فیلمی با این مشخصات نیست.");
//                continue;
//            }
//            System.out.print("تعداد بلیط:");
//            int count = scanner.nextInt();
//
//            if (count <= 0) {
//                System.out.println("تعداد وارد شده معتبر نیست.");
//                continue;
//            }
//            if (movieLogic.buyingTicket(selected, count)) {
//                double total = count * selected.getPrice();
//                System.out.printf("خرید موفق. مبلغ کل: %.2f$\n", total);
//            } else {
//                System.out.println("بلیط کافی موجود نیست.");
//            }
//        }
//    }
//}

