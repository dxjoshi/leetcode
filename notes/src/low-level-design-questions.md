## Popular Java LLD questions solution

### Link to Source Code        

- [Shopping Cart LLD](https://drive.google.com/file/d/1kGkbH0aTWl8riru9qX-dLG8MkBLlW2P9/view)       
- [Hotel Management LLD](https://drive.google.com/file/d/1GFDk4DBOtefSbuUioAQ5D3T2-cH9m47l/view)             
- [Library Management LLD](https://drive.google.com/file/d/1Ei_-35j6jqAq716n4Skfa0-ohPlp4kma/view)               
- [Ticketmaster/BookMyShow LLD](https://drive.google.com/file/d/1sFRpPiT7g3e-giiqt2Fuzara5Am_JtzE/view)              
- [ATM LLD](https://drive.google.com/file/d/1jN0V5eCjETnI3XLfqCncWzapSLWPSqMV/view)              
- [Chess LLD](https://drive.google.com/file/d/10nHLISCMcpgn6yl-0C1FgW303CLrD1S7/view)       
- [Parking Lot LLD](https://drive.google.com/file/d/1cDLJQA4_RiqE5d2cCekhpTuVfLDnT_o0/view)         
- [StackOverflow LLD](https://drive.google.com/file/d/1w7Hlq6bsafqghunb9xhqsCR2XMFY2e2f/view)           
               
               
### Link to Source Code         
- [Shopping Cart LLD](https://github.com/dxjoshi/leetcode/blob/8e15fc3955461073cb94559e61e38cb5a2a97814/low-level-design/src/AMZN.java)               
- [Hotel Management LLD](https://github.com/dxjoshi/leetcode/blob/8e15fc3955461073cb94559e61e38cb5a2a97814/low-level-design/src/HMS.java)             
- [Library Management LLD](https://github.com/dxjoshi/leetcode/blob/8e15fc3955461073cb94559e61e38cb5a2a97814/low-level-design/src/LMS.java)               
- [Ticketmaster/BookMyShow LLD](https://github.com/dxjoshi/leetcode/blob/8e15fc3955461073cb94559e61e38cb5a2a97814/low-level-design/src/BMS.java)              
- [ATM LLD](https://github.com/dxjoshi/leetcode/blob/8e15fc3955461073cb94559e61e38cb5a2a97814/low-level-design/src/ATM.java)              
- [Chess LLD](https://github.com/dxjoshi/leetcode/blob/8e15fc3955461073cb94559e61e38cb5a2a97814/low-level-design/src/Chess.java)       
- [Parking Lot LLD](https://github.com/dxjoshi/leetcode/blob/8e15fc3955461073cb94559e61e38cb5a2a97814/low-level-design/src/ParkingLot.java)         
- [StackOverflow LLD](https://github.com/dxjoshi/leetcode/blob/8e15fc3955461073cb94559e61e38cb5a2a97814/low-level-design/src/StackOverflow.java)           
     
       
### Solutions     
- [Shopping Cart LLD](https://github.com/dxjoshi/leetcode/blob/8e15fc3955461073cb94559e61e38cb5a2a97814/low-level-design/src/AMZN.java)                     


        class Customer {
            ShoppingCart cart;
            Search searchObj;
            int customerId;
        
            public ShoppingCart getShoppingCart(customerId);
            public void addItemsToShoppingCart(Item item);
            public void updateItemFromShoppingCart(Item item);
            public void removeItemFromShoppingCart(Item item);
        }
        
        class Guest extends Customer {
            public Account createNewAccount();
        }
        
        class User extends Customer {
            Account account;
        }
        
        class Seller extends User {
            public void addProduct(Product product);
        }
        
        class Buyer extends User {
            Order orderObj;
        
            public void addReview(ProductReview review);
            public OrderStatus placeOrder(ShoppingCart cart);
        }
        
        class Account {
            String name;
            String email;
            String phoneNumber;
            String userName;
            String password;
            List<Address> shippingAdresses;
            AccountStatus accountStatus;
        }
        
        class Address {
            int pinCode; //ZipCode
            String street;
            String city;
            String state;
            String country;
        }
        
        public enum AccountStatus {
            ACTVE,BLOCKED,INACTIVE;
        }
        
        class ShoppingCart {
            List<Item> items;
            double cartValue;
        
            public void addItem(Item item);
            public void updateItem(Item item);
            public void deleteItem(Item item);
            public void checkoutItems();
            public List<Item> getItems();
            public double getCartValue();
        }
        
        class Item {
            Product product;
            int qty;
        }
        
        class Product {
            int productId;
            String productDescription;
            String name;
            ProductCategory productCategory;
            Seller seller;
            double cost;
            List<ProductReview> productReviews;
        }
        
        public enum ProductCategory {
            ELECTRONICS,FURNITURE,GROCERY,MOBILE;
        }
        
        class ProductReview {
            String details;
            Buyer reviewer;
            int rating;
        }
        
        class search {
            public List<Product> searchByName(String name);
            public List<Product> searchByCategory(ProductCategory productCategory);
        }
        
        class Order {
            int orderId;
            List<Item> orderItem;
            double orderValue;
            Buyer buyer;
            Date orderDate;
            NotificationService notificationService;
            List<OrderLog> orderLog;
            public OrderStatus placeOrder();
            public OrderStatus trackOrder();
            public void addOrderLogs();
            public PaymentStatus makePayment(PaymentType paymentType);
        }
        
        public enum OrderStatus {
            PACKED, SHIPPED, ENROUTE, OUT_FOR_DELIVERY, DELIVERED, CANCELLED;
        }
        
        public enum PaymentStatus {
            SUCCESS, ERROR, CANCELLED, REFUND_INITIATED, REFUNDED;
        }
        
        public enum PaymentType {
            CREDIT_CARD, DEBIT_CARD, NET_BANKING, UPI;
        }
        
        class OrderLog {
            String orderDetail;
            Date createdDate;
            OrderStatus status;
        }
        
        class NotificationDomain {
            String notificationID;
            NotificationType notificationType;
            User user;
        }
        
        class NotificationService {
            public boolean sendNotification(NotificationDomain notificationDomain) {
                Notification notificationObject;
                MessageAttribute messageAttribute;
                switch(notificationDomain.getNotificationType()) {
                    case NotificationType.EMAIL:
                        notificationObject = new EmailNotification();
                        messageAttribute = new MessageAttribute("abc@abc.com", notificationDomain.getUser().getAccount().getEmail(),"Order Detail ...");
                        break;
                    case NotificationType.WHATSAPP:
                        notificationObject = new WhatsappNotification();
                        messageAttribute = new MessageAttribute("9888888888", notificationDomain.getUser().getAccount().getPhoneNumber(),"Order Detail ...");
                        break;
                    default:
                        notificationObject = new SMSNotification();
                        messageAttribute = new MessageAttribute("988888888", notificationDomain.getUser().getAccount().getPhoneNumber(),"Order Detail ...");
                        break;
                }
                return notificationObject.sendNotification(messageAttribute);
            }
        }
        
        class MessageAttributes {
            String to;
            String from;
            String message;
        }
        
        interface Notification {
            boolean sendNotification(MessageAttribute meesageAttribute);
        }
        
        class EmailNotification implements Notification {
            boolean sendNotification(MessageAttribute meesageAttribute);
        }
        
        class WhatsappNotification implements Notification {
            boolean sendNotification(MessageAttribute meesageAttribute);
        }
        
        class SMSNotification implements Notification {
            boolean sendNotification(MessageAttribute meesageAttribute);
        }
   
- [Hotel Management LLD](https://github.com/dxjoshi/leetcode/blob/8e15fc3955461073cb94559e61e38cb5a2a97814/low-level-design/src/HMS.java)                   


        class Hotel {
            String Name;
            Integer id;
            Location hotelLocation;
            List<Room> roomList;
        }
        
        class Location {
            Double longitude;
            Double latitude;
        }
        
        class Room {
            String roomNumber;
            RoomStyle roomStyle;
            RoomStatus roomStatus;
            Double bookingPrice;
            List<RoomKey> roomKeys;
            List<HouseKeepingLog> houseKeepingLogs;
        }
        
        public enum RoomStyle {
            STANDARD, DELUX, FAMILY_SUITE;
        }
        
        public enum RoomStatus {
            AVAILABLE, RESERVED, NOT_AVAILBLE, OCCUPIED, SERVICE_IN_PROGRESS;
        }
        
        class RoomKey {
            String keyId;
            String barCode;
            Date issuedAt;
            Boolean isActive;
            Boolean isMaster;
        
            public void assignRoom(Room room);
        }
        
        class HouseKeepingLog {
            String description;
            Date startDate;
            int duration;
            HouseKeeper houskeeper;
        
            public void addRoom(Room room);
        }
        
        abstract class Person {
            String name;
            Account accountDetail;
            String phone;
        }
        
        public class Account {
            String username;
            String password;
            AccountStatus accountStatus;
        }
        
        public enum AccountStatus {
            ACTIVE, CLOSED, BLOCKED;
        }
        
        class HouseKeeper extends Person {
            public List<Room> public getRoomsServiced(Date date);
        }
        
        class Guest extends Person {
            Search searchObj;
            Booking bookingObj;
        
            public List<RoomBooking> getAllRoomBookings();
            public RoomBooking createBooking();
            public RoomBooking cancelBooking(int bookingId);
        }
        
        class Receptionist extends Person {
            Search searchObj;
            Booking bookingObj;
        
            public void checkInGuest(Guest guest, RoomBooking bookingInfo);
            public void checkOutGuest(Guest guest, RoomBooking bookingInfo);
        }
        
        class admin extends Person {
            public void addRomm(Room roomDetail);
            public Room deleteRoom(String roomId);
            public void editRoom(Room roomDetail);
        }
        
        class search {
            public List<Room> searchRoom(RoomStyle roomStyle, Date startDate, int duration);
        }
        
        class RoomBooking {
            String bookingId;
            Date startDate;
            Int durationInDays;
            BookingStatus bookingStatus;
            List<Guest> guestList;
            List<Room> roomInfo;
            BaseRoomCharge totalRoomCharges;
        }
        
        //Decorator pattern is used to decorate the prices here.
        interface BaseRoomCharge {
            Double getCost();
        }
        
        class RoomCharge implements BaseRoomCharge {
            double cost;
            Double getCost() {
                return cost;
            }
            void setCost(double cost) {
                this.cost = cost;
            }
        }
        
        class RoomServiceCharge implements BaseRoomCharge {
            double cost;
            BaseRoomCharge baseRoomCharge;
            Double getCost() {
                baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
                return baseRoomCharge.getCost();
            }
        }
        
        class InRoomPurchaseCharges implements BaseRoomCharge {
            double cost;
            BaseRoomCharge baseRoomCharge;
            Double getCost() {
                baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
                return baseRoomCharge.getCost();
            }
        }
        
        class Booking {
            public RoomBooking createBooking(Guest guestInfo);
            public RoomBooking cancelBooking(int bookingId);
        }
  
- [Library Management LLD](https://github.com/dxjoshi/leetcode/blob/8e15fc3955461073cb94559e61e38cb5a2a97814/low-level-design/src/LMS.java)                 


        class Library {
            String name;
            Address location;
            List<BookItem> books;
        }
        
        class Book {
            String uniqueIdNumber;
            String title;
            List<Author> authors;
            BookType bookType;
        }
        
        class BookItem extends Book {
            String barcode;
            Date publicationDate;
            Rack rackLocation;
            BookStatus bookStatus;
            BookFormat bookFormat;
            Date issueDate;
        }
        
        class Address {
            int pinCode //ZipCode
            String street;
            String city;
            String state;
            String country;
        }
        
        public enum BookType {
            SCI_FI, ROMANTIC, FANTASY, DRAMA;
        }
        
        public enum BookFormat {
            HARDCOVER, PAPERBACK, NEWSPAPER, JOURNAL;
        }
        
        public enum BookStatus {
            ISSUED, AVAILABLE, RESERVED, LOST;
        }
        
        class Rack {
            int number;
            String locationId;
        }
        
        class Person {
            String firstName;
            String lastName;
        }
        
        class Author extends Person {
            List<Book> booksPublished;
        }
        
        class SystemUser extends Person {
            String Email;
            String phoneNumber;
            Account account;
        }
        
        class Member extends SystemUsers {
            int totalBookCheckedOut;
            Search searchObj;
            BookIssueService issueService;
        }
        
        class Librarian extends SystemUsers {
            Search searchObj;
            BookIssueService issueService;
        
            public void addBookItem(BookItem bookItem);
            public BookItem deleteBookItem(String barcode); 
            public BookItem editBookItem(BookItem bookItem);
        }
        
        class Account {
            String userName;
            String password;
            int accountId;
        }
        
        class Search {
            public List<BookItem> geBookByTitle(String title);
            public List<BookItem> geBookByAuthor(Author author);
            public List<BookItem> geBookByType(BookType bookType);
            public List<BookItem> geBookByPublicationDate(Date publicationDate);
        }
        
        class BookIssueService {
            Fine fine;
        
            public BookReservationDetail getReservationDetail(BookItem book);
            public void updateReservationDetail(BookReservationDetail bookReservationDetail);
            public BookReservationDetail reserveBook(BookItem book, SystemUser user);
            public BookIssueDetail issueBook(BookItem book, SystemUser user);
            // it will internaly call the issueBook function after basic validations
            public BookIssueDetail renewBook(BookItem book, SystemUser user); 
            public void returnBook(BookItem book, SystemUser user);
        }
        
        class BookLending {
            BookItem book;
            Date startDate;
            SystemUser user;
        }
        
        class BookReservationDetail extends BookLending {
            ReservationStatus reservationStatus;
        }
        
        class BookIssueDetail extends BookLending {
            Date dueDate;
        }
        
        class Fine {
            Date fineDate;
            BookItem book;
            SystemUser user;
        
            public double calculateFine(int days);
        }
      
- [Ticketmaster/BookMyShow LLD](https://github.com/dxjoshi/leetcode/blob/8e15fc3955461073cb94559e61e38cb5a2a97814/low-level-design/src/BMS.java)            


        public class BMSService  {
            List<CinemaHall> cinemas;
        
            public List<Movie> getMovies(Date date, String city);
            public List<CinemaHall> getCinemalHalls(String city);
        }
        
        public class CinemaHall {
            int cinemaHallId;
            String cinemaHallName;
            Address address;
            List<Audi>audiList;
        
            public Map<Date, Movies> getMovies(List<Date> dateList);
            public Map<Date, Show> getShows(List<Date> dateList);
        }
        
        public class Address {
            int pinCode; //ZipCode
            String street;
            String city;
            String state;
            String country;
        }
        
        public class Audi {
            int audiId;
            String audiName;
            int totalSeats;
            List<Show> shows;
        }
        
        public class Show {
            int showId;
            Movie movie;
            Date startTime;
            Date endTime;
            CinemaHall cinemaPlayedAt;
            List<Seat> seats;
        }
        
        public class Seat {
            int seatId;
            SeatType seatType;
            SeatStatus seatStatus;
            Double price;
        }
        
        
        public enum SeatType {
            DELUX, VIP, ECONOMY, OTHER;
        }
        
        public enum SeatStatus {
            BOOKED, AVAILABLE, RESERVED, NOT_AVAILABLE;
        }
        
        public class Movie {
            String movieName;
            int movieId;
            int durationInMins;
            String language;
            Genre genre;
            Date releaseDate;
            Map<String, List<Show>> cityShowMap;
        }
        
        public enum Genre {
            SCI_FI, DRAMA, ROM_COM, FANTASY;
        }
        
        public class User {
            int userId;
            Search searchObj;
        }
        
        public class SystemMember extends User {
            Account account;
            String name;
            String email;
            Address address;
        }
        
        public class Member extends SystemMember {
            public Booking makeBooking(Booking booking);
            public List<Booking> getBooking();
        }
        
        public class Admin extends SystemMember {
            public boolean addMovie(Movie moivie);
            public boolean addShow(Show show);
        }
        
        public class Account {
            String userName;
            String password;
        }
        
        public class Search {
            public List<Movie> searchMoviesByNames(String name);
            public List<Movie> searchMoviesByGenre(Genre genre);
            public List<Movie> searchMoviesByLanguage(String language);
            public List<Movie> searchMoviesByDate(Date releaseDate);
        }
        
        public class Booking {
            String bookingId;
            Date bookingDate;
            Member member;
            Audi audi;
            Show show;
            BookingStatus bookingStatus;
            double totalAmount;
            List<Seat> seats;
            Payment paymentObj;
        
            public boolean makePayment(Payment payment);
        }
        
        public class Payment {
            double amount;
            Date paymentDate;
            int transactionId;
            PaymentStatus paymentStatus;
        }
        
        public enum BookingStatus {
            REQUESTED, PENDING, CONFIRMED, CANCELLED;
        }
        
        public enum PaymentStatus {
            UNPAID, PENDING, COMPLETED, DECLINED, CANCELLED, REFUNDED;
        }
          
- [ATM LLD](https://github.com/dxjoshi/leetcode/blob/8e15fc3955461073cb94559e61e38cb5a2a97814/low-level-design/src/ATM.java)                    


        class ATM {
            int atmId;
            Address location;
            CashDispenser cashDispenser;
            Screen screen;
            CardReader cardReader;
            Keypad keypad;
            CashDeposit cashDeposit;
            ChequeDeposit chequeDeposit;
            BankService bankService;
        }
        
        class Address {
            int pinCode; //ZipCode
            String street;
            String city;
            String state;
            String country;
        }
        
        class CashDispenser {
            Map<CashType, List<Cash>> cashAvailable;
            public void dispenseCash(int amount);
        }
        
        public enum CashType {
            FIFTY, HUNDRED, FIVEHUNDRED;
        }
        
        public Cash {
            CashType cashType;
            String serialNumber;
        }
        
        class Screen {
            public void display(String message);
        }
        
        class CardReader {
            public CardInfo fetchCardDetails();
        }
        
        class CardInfo {
            CardType cardType;
            Bank bank;
            String cardNumber;
            Date expiryDate;
            int cvv;
            float withdrawLimit;
        }
        
        public enum CardType {
            DEBIT,CREDIT;
        }
        
        class Keypad {
            public String getInput();
        }
        
        
        class Bank {
            String name;
            Address location;
            List<ATM> atmList;
        }
        
        interface BankService {
            public Boolean isValidUser(String pin, CardInfo cardInfo);
            public Customer getCustomerDetails(CardInfo cardInfo);
            public TransactionDetail executeTransaction(Transaction transactionInfo, Customer customer);
        }
        
        class BankA implements BankService {
            public Boolean isValidUser(String pin, CardInfo cardInfo);
            public Customer getCustomerDetails(CardInfo cardInfo);
        }
        
        class BankB implements BankService {
            public Boolean isValidUser(String pin, CardInfo cardInfo);
            public Customer getCustomerDetails(CardInfo cardInfo);
        }
        
        class BankServiceFactory {
            //It will return BankA / BankB object so that for transacting we can use that.
            public BankService getBankServiceObject(CardInfo cardInfo);
        }
        
        class Customer {
            String firstName;
            String lastName;
            String accountNumber;
            CardInfo cardInfo;
            Account account;
            BankService bankServiceObj;
            CustomerStatus customerStatus;
        }
        
        //We can divide this into further sub classes depending on requirements! 
        //into savings and current accounts.
        class Account {
            String accountNumber;
            Float availableBalance;
        }
        
        public enum CustomerStatus {
            BLOCKED, ACTIVE, CLOSED;
        }
        
        class Transaction {
            Integer transactionId;
            String sourceAccount;
            Date transactionDate;
        }
        
        class Deposit extends Transaction {
            float amount;
        }
        
        class ChequeDeposit extends Deposit {
            public Cheque getCheque();
        }
        
        class CashDeposit extends Deposit {
            public List<Cash> getCash();
        }
        
        class Withdraw extends Transaction {
            float amount;
        }
        
        class Transfer extends Transaction {
            String destAccunt;
            float amount;
        }
        
        class TransactionDetail {
            TransactionStatus transactionStatus;
            String sourceAccountNumber;
            Date transactionDate;
            TransactionType transactionType;
            int transactionId;
        }
        
        public enum TransactionStatus {
            PENDING, CANCELLED, SUCCESS, ERROR;
        }
        
        public enum TransactionType {
            WITHDRAW, DEPOSIT, TRANSFER;
        }

- [Chess LLD](https://github.com/dxjoshi/leetcode/blob/8e15fc3955461073cb94559e61e38cb5a2a97814/low-level-design/src/Chess.java)            


        public class Chess {
            ChessBoard chessBoard;
            Player[] player;
            Player currentPlayer;
            List<Move> movesList;
            GameStatus gameStatus;
        
            public boolean playerMove(CellPosition fromPosition, CellPositionb toPosition, Piece piece); 
            public boolean endGame();
            private void changeTurn();
        }
        
        public class Player {
            Account account;
            Color color;
            Time timeLeft;
        }
        
        public class Time {
            int mins;
            int secs;
        }
        
        public enum Color {
            BLACK, WHITE;
        }
        
        public class Account {
            String username;
            String password;
        
            String name;
            String email;
            String phone;
        }
        
        public enum GameStatus {
            ACTIVE, PAUSED, FORTFEIGHT, BLACK_WIN, WHITE_WIN;
        }
        
        public class ChessBoard {
            List<List<Cell>>> board;
        
            public void resetBoard();
            public void updateBoard(Move move);
        }
        
        public class Cell {
            Color color;
            Piece piece;
            CellPosition position;
        }
        
        public class CellPosition {
            Char ch;
            int i;
        }
        
        public class Move {
            Player turn;
            Piece piece;
            Piece killedPiece;
            CellPosition startPosition;
            CellPosition endPosition;
        }
        
        public abstract class Piece {
            Color color;
        
            public boolean move(CellPosition fromPosition, CellPositionb toPosition);
            public List<CellPosition> possibleMoves(CellPosition fromPosition);
            public boolean validate(CellPosition fromPosition, CellPositionb toPosition);
        }
        
        public class Knight extends Piece {
            public boolean move(CellPosition fromPosition, CellPositionb toPosition);
            public List<CellPosition> possibleMoves(CellPosition fromPosition);
            public boolean validate(CellPosition fromPosition, CellPositionb toPosition);
        }
        
        public class Bishop extends Piece {
            public boolean move(CellPosition fromPosition, CellPositionb toPosition);
            public List<CellPosition> possibleMoves(CellPosition fromPosition);
            public boolean validate(CellPosition fromPosition, CellPositionb toPosition);
        }
        
        public class rook extends Piece {
            public boolean move(CellPosition fromPosition, CellPositionb toPosition);
            public List<CellPosition> possibleMoves(CellPosition fromPosition);
            public boolean validate(CellPosition fromPosition, CellPositionb toPosition);
        }
        
        public class King extends Piece {
            public boolean move(CellPosition fromPosition, CellPositionb toPosition);
            public List<CellPosition> possibleMoves(CellPosition fromPosition);
            public boolean validate(CellPosition fromPosition, CellPositionb toPosition);
        }
        
        public class Queen extends Piece {
            public boolean move(CellPosition fromPosition, CellPositionb toPosition);
            public List<CellPosition> possibleMoves(CellPosition fromPosition);
            public boolean validate(CellPosition fromPosition, CellPositionb toPosition);
        }
        
        public class Pawn extends Piece {
            public boolean move(CellPosition fromPosition, CellPositionb toPosition);
            public List<CellPosition> possibleMoves(CellPosition fromPosition);
            public boolean validate(CellPosition fromPosition, CellPositionb toPosition);
        }

- [Parking Lot LLD](https://github.com/dxjoshi/leetcode/blob/8e15fc3955461073cb94559e61e38cb5a2a97814/low-level-design/src/ParkingLot.java)                 


        class ParkingLot {
            List<ParkingFloor> parkingFloors;
            List<Entrance> entrances;
            List<Exit> exits;
            Address address;
            String parkingLotName;
        
            public boolean isParkingSpaceAvailableForVehicle(Vehicle vehicle);
            public boolean updateParkingAttndant(ParkingAttendant parkingAttendant, int gateId);
        }
        
        class ParkingFloor {
            int levelId;
            List<ParkingSpace> parkingSpaces;
            ParkingDisplayBoard parkingDisplayBoard;
        }
        
        class Gate {
            int gateId;
            ParkingAttendant parkingAttendant;
        }
        
        class Entrance extends Gate {
            public ParkingTicket getParkingTicket(Vehicle vehicle);
        }
        
        class Exit extends Gate {
            public ParkingTicket payForParking(ParkingTicket parkingTicket, PaymentType paymentType);
        }
        
        
        class Address {
            String country;
            String state;
            String city;
            String street;
            String pinCode; //ZipCode
        }
        
        class ParkingSpace {
            int spaceId;
            boolean isFree;
            double costPerHour;
            Vehicle vehicle;
            ParkingSpaceType parkingSpaceType;
        }
        
        class ParkingDisplayBoard {
            Map<ParkingSpaceType, Integer> freeSpotsAvailableMap;
        
            public void updateFreeSpotsAvailable(ParkingSpaceType parkingSpaceType, int spaces);
        }
        
        
        class Account {
            String name;
            String email;
            String password;
            String empId;
            Address address;
        }
        
        class Admin extends Account {
            public boolean addParkingFloor(ParkingLot parkingLot, ParkingFloor floor);
            public boolean addParkingSpace(ParkingFloor floor, ParkingSpace parkingSpace);
            public boolean addParkingDisplayBoard(ParkingFloor floor, ParkingDisplayBoard parkingDisplayBoard);
        }
        
        class ParkingAttendant extends Account {
            Payment paymentService;
        
            public boolean processVehicleEntry(Vehicle vehicle);
            public PaymentInfo processPayment(ParkingTicket parkingTicket, PaymentType paymentType);
        }
        
        class Vehicle {
            String licenseNumber;
            VehicleType vehicleType;
            ParkingTicket parkingTicket;
            PaymentInfo paymentInfo;
        }
        
        class ParkingTicket {
            int ticketId;
            int levelId;
            int spaceId;
            Date vehicleEntryDateTime;
            Date vehicleExitDateTime;
            ParkingSpaceType parkingSpaceType;
            double totalCost;
            ParkingTicketStatus parkingTicketStatus;
        
            public void updateTotalCost();
            public void updateVehicleExitTime(Date vehicleExitDateTime);
        }
        
        public enum PaymentType {
            CASH, CEDIT_CARD, DEBIT_CARD, UPI;
        }
        
        public enum ParkingSpaceType {
            BIKE_PARKING, CAR_PARKING, TRUCK_PARKING
        }
        
        class Payment {
            public PaymentInfo makePayment(ParkingTicket parkingTicket, PaymentType paymentType);
        }
        
        public class PaymentInfo {
            double amount;
            Date paymentDate;
            int transactionId;
            ParkingTicket parkingTicket;
            PaymentStatus paymentStatus;
        }
        
        public enum VehicleType {
            BIKE, CAR, TRUCK;
        }
        
        public enum ParkingTicketStatus {
            PAID, ACTIVE;
        }
        
        public enum PaymentStatus {
            UNPAID, PENDING, COMPLETED, DECLINED, CANCELLED, REFUNDED;
        }

- [StackOverflow LLD](https://github.com/dxjoshi/leetcode/blob/8e15fc3955461073cb94559e61e38cb5a2a97814/low-level-design/src/StackOverflow.java)            


        class User {
            int guestId;
            Search searchObj;
        
            public List<Question> getQuestions(String searchString);
        }
        
        class Member extends User{
            Account account;
            List<Badge> badges;
        
            public void addQuestion(Question question);
            public void addComment(Entity entity, Comment comment);
            public void addAnswer(Question question, Answer answer);
            public void vote(Entity entity, VoteType voteType);
            public void addTag(Question question, Tag tag);
            public void flag(Entity entity);
            public List<Badge> getBadges();
        }
        
        class Account {
            String name;
            Address address;
            int accountId;
            String userName;
            String password;
            String email;
            AccountStatus accountStatus;
            int reputation;
        }
        
        class Moderator extends Member {
            public Boolean closeQuestion(Question question);
            public Boolean restoreQuestion(Quetion question);
        }
        
        class Admin extends Member {
            public Boolean blockMember(Member member);
            public Boolean unblockMember(Member member);
        }
        
        public enum AccountStatus {
            BLOCKED, ACTIVE, CLOSED;
        }
        
        public enum VoteType {
            UPVOTE, DOWNVOTE, CLOSEVOTE, DELETEVOTE;
        }
        
        public class Badge {
            String name;
            String description;	
        }
        
        public class Entity {
            int entityId;
            Member creator;
            Map<VoteType, Integer> votes;
            Date createdDate;
            List<Comment> comments;
        
            public boolean flagEntity(Member member);
            public boolean voteEntity(VoteType voteType);
            public boolean addComment(Comment comment);
        }
        
        public class Comment extends Entity {
            String message;
        }
        
        public class Question extends Entity {
            List<EditHistory> editHistoryList;
            List<Answer> answerList;
            List<Tag> tags;
            String title;
            String description;
            QuestionStatus status;
        
            public boolean addQuestion();
            public boolean addTag(Tag tag);
        }
        
        public class Answer extends Entity {
            String answer;
            Boolean isAccepted;
            public boolean addAnswer(Question question);
        }
        
        public enum QuestionStatus {
            ACTIVE, BOUNTIED, CLOSED, FLAGGED;
        }
        
        public class Tag {
            String name;
            String description;
        }
        
        public class EditHistory {
            int editHistoryId;
            Member creator;
            Date creationDate;
            Question prevQuestion;
            Question updatedQuestion;
        }