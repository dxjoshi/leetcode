## GOF Design Patterns:  

## Topics:

### Design Principles:
* [SOLID Principles](#solid-principles)
* [Principle of Least Knowledge(Law Of Demeter)](#principle-of-least-knowledge)
* [The Hollywood Principle](#the-hollywood-principle)
* [Object Oriented Principles](#object-oriented-principles)
* [Thinking in Patterns](#thinking-in-patterns)
* [Important Notes](#important-notes)

### Creational:             
* [Singleton](#singleton)
* [Builder](#builder)
* [Factory](#factory)
* [Abstract](#abstract)
* [Prototype](#prototype)

### Structural:         
* [Adapter](#adapter)
* [Composite](#composite)
* [Proxy](#proxy)
* [Flyweight](#flyweight)
* [Facade](#facade)
* [Bridge](#bridge)
* [Decorator](#decorator)

### Behavioral:         
* [Template](#template)
* [Mediator](#mediator)
* [Chain Of Responsibility](#chain-of-responsibility)
* [Observer](#observer)
* [Strategy](#strategy)
* [Command](#command)
* [State](#state)
* [Visitor](#visitor)
* [Interpreter](#interpreter)
* [Iterator](#iterator)
* [Memento](#memento)


### SOLID Principles
- [SOLID Principles](https://www.baeldung.com/solid-principles):

1. **Single Responsibility Principle:**
   > A class should have only one reason to change.
2. **Open-Closed Principle:**  
   > Classes should be open for extension but closed for modification.  
3. **Liskov Substitution Principle:**  
   > Subclasses should be substitutable for their base classes.  
   For ex. If class A is a subtype of class B, then we should be able to replace B with A without breaking the application
4. **Interface Segregation Principle:**  
   > Clients should not be forced to implement interfaces that they do not use.
5. **Dependency Inversion Principle:**     
   > Depend on abstractions, not on concretions.  
   > 1. High-level modules should not depend on low-level modules. Both should depend on abstractions. 
   > 2. Abstractions should not depend on details. Details should depend on abstractions. 
   
### Principle of Least Knowledge            
- [Principle of Least Knowledge(Law Of Demeter)](https://dzone.com/articles/the-genius-of-the-law-of-demeter) 
For all classes C, and for all methods M attached to C, all objects to which M sends a message must be:     

1. self (this in Java)
1. M’s argument objects
1. Instance variable objects of C
1. Objects created by M, or by functions or methods which M calls
1. Objects in global variables (static fields in Java)      
**PS**: The term “objects to which M sends a message” roughly translates to “objects used by M,” or in a more practical definition “objects on which M calls a method on.”

### The Hollywood Principle         
- [The Hollywood Principle](https://deviq.com/principles/hollywood-principle):      
- With the Hollywood Principle, we allow low-level components to hook themselves into a system, but the high-level components determine when they are needed, and how. In other words, the high-level components give the low-level components a “don’t call us, we’ll call you” treatment.

### Object Oriented Principles:  
1. Encapsulate what varies.
2. Favour composition over inheritance.
3. Program to an interface, not an implementation.
4. Strive for loosely coupled designs between objects that interact.
5. A cohesive class does one thing very well and doesn't try to do or be something else.         
6. The software must do what its customers wants it to do. Apply basic OO principles to add flexibility. Strive for a maintainable reusable design.     
7. Don't Repeat Yourself (DRY): Avoid duplicate code by abstracting out things that are common andplacing those things in a single location.    
    
### Thinking in Patterns:    
- Keep it simple (KISS)
- Design Patterns aren’t a magic bullet; in fact, they’re not even a bullet!    
- You know you need a pattern when...   
- Refactoring time is Patterns time!    
- Take out what you don’t really need. Don’t be afraid to remove a Design Pattern from your design.     
- If you don’t need it now, don’t do it now.    
- **Your Mind in Patterns**:   
    - **The Beginner** uses patterns everywhere.    
    - As learning progresses, **the Intermediate** mind starts to see where patterns are needed and where they aren’t.  
    - **The Zen** mind is able to see patterns where they fit naturally.    
- **Anti-Pattern**:  
    - An anti-pattern tells you why a bad solution is attractive.
    - An anti-pattern tells you why that solution in the long term is bad.
    - An anti-pattern suggests other patterns that are applicable which may provide good solutions. 
- **Used at Work?** 
    - Template Method Pattern --- AbstractDataSourceN6Feed in yc-feedhandler implementation     

### Important Notes:
- **Hollywood Principle vs Dependency Inversion Principle:**
    - The Dependency Inversion Principle teaches us to avoid the use of concrete classes and instead work as much as possible with abstractions. The Hollywood Principle is a technique for building frameworks or components so that lower-level components can be hooked into the computation, but without creating dependencies between the lower-level components and the higher-level layers. So, they both have the goal of decoupling, but the Dependency Inversion Principle makes a much stronger and general statement about how to avoid dependencies in design.
    - The Hollywood Principle gives us a technique for creating designs that allow low-level structures to interoperate while preventing other classes from becoming too dependent on them.  

- **IS-A vs HAS-A:** 
    - IS-A refers to inheritance whereas HAS-A refers to composition or aggregation.
    - IS-A breaks in certain situations(Square IS-A Rectangle), so use inheritance when one object behaves like another, rather just when the IS-A relationship applies.    

### Singleton
- It ensures a class has only one instance, and provides a global point of access to it.                

- Eager Singleton


        public class EagerSingleton {
            private static EagerSingleton INSTANCE = new EagerSingleton();
        
            public static EagerSingleton getInstance() { return INSTANCE; }
        }

- Enum Singleton        
    
    
        public enum EnumSingleton {
            INSTANCE;
        
            public static EnumSingleton getInstance() {
                return INSTANCE;
            }
        }
            
- Lazy Singleton


        public class LazySingleton {
        
            private static LazySingleton INSTANCE;
        
            public static LazySingleton getInstance() {
                if (INSTANCE == null)  INSTANCE = new LazySingleton();
                return INSTANCE;
            }
        }
        
- BillPugh Singleton


        public class BillPughSingleton {
            // Notice the private inner static class that contains the instance of the singleton class.
            // When the singleton class is loaded, SingletonHelper class is not loaded into memory and
            // only when someone calls the getInstance method, this class gets loaded and creates the Singleton class instance.
            private static class SingletonHelper {
                private static BillPughSingleton INSTANCE = new BillPughSingleton();
            }
        
            public static BillPughSingleton getInstance() {
                return SingletonHelper.INSTANCE;
            }
        }

- Thread Safe Singleton 


        public class ThreadSafeSingleton {
            private static ThreadSafeSingleton INSTANCE;
        
            // By adding synchronized we make all thread wait until its turn before 
            // they can enter the getInstance method. NO TWO THREADS MAY ENTER AT THE SAME TIME.
            public static synchronized ThreadSafeSingleton getInstance() {
                if (INSTANCE == null)  INSTANCE = new ThreadSafeSingleton();
                return INSTANCE;
            }
        }    

- Double Checked Locking    


        public class DoubleCheckLockingSingleton {
            private volatile static DoubleCheckLockingSingleton INSTANCE;
        
            // With double-checked locking, we first check to see if an instance is created, and if not, THEN we synchronize.
            // This way, we only synchronize the first time through, just what we want.

            public static DoubleCheckLockingSingleton getInstance() {
                if (INSTANCE == null)  {
                    synchronized (DoubleCheckLockingSingleton.class) {
                        if (INSTANCE == null) {
                            INSTANCE = new DoubleCheckLockingSingleton();
                        }
                    }
                }
                return INSTANCE;
            }
        }
        
- Reflection Singleton Test
    
    
        public class ReflectionSingletonTest {
        
            public static void main(String[] args) {
                EagerSingleton instanceOne = EagerSingleton.getInstance();
                EagerSingleton instanceTwo = null;
                try {
                    Constructor[] constructors = EagerSingleton.class.getDeclaredConstructors();
                    for (Constructor constructor : constructors) {
                        //Below code will destroy the singleton pattern
                        constructor.setAccessible(true);
                        instanceTwo = (EagerSingleton) constructor.newInstance();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(instanceOne.hashCode());
                System.out.println(instanceTwo.hashCode());
            }
        }


### Builder
- [Josh Block's Builder Pattern](https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java)                    
- Use the Builder Pattern to encapsulate the construction of a product and allow it to be constructed in steps.             

        
        import java.time.Year;
        
        public class Book {
            private final String isbn;
            private final String title;
            private final String genre;
            private final String author;
            private final Year published;
            private final String description;
            
            //    private constructor
            private Book(Builder builder) {
                this.isbn = builder.isbn;
                this.title = builder.title;
                this.genre = builder.genre;
                this.author = builder.author;
                this.published = builder.published;
                this.description = builder.description;
            }
        
            // all getters
            
            //   static inner builder class
            public static class Builder {
                private final String isbn;
                private final String title;
                private String genre;
                private String author;
                private Year published;
                private String description;
        
                public Builder(String isbn, String title) {
                    this.isbn = isbn;
                    this.title = title;
                }
        
                public Builder genre(String genre) {
                    this.genre = genre;
                    return this;
                }
        
                public Builder author(String author) {
                    this.author = author;
                    return this;
                }
        
                public Builder published(Year published) {
                    this.published = published;
                    return this;
                }
        
                public Builder description(String description) {
                    this.description = description;
                    return this;
                }
        
                public Book build() {
                    return new Book(this);
                }
            }
        }
        
        
### Factory             
- Defines interface for creating an object, but lets subclasses define which class to instantiate.                     
- It lets a class defer instantiation to subclasses.  
- [Source Link](https://refactoring.guru/design-patterns/factory-method/java/example#lang-features)                   
      
      
      public interface Button {
          void render();
          void onClick();
      }
      
      public class HtmlButton implements Button {
      
          public void render() {
              System.out.println("<button>Test Button</button>");
              onClick();
          }
      
          public void onClick() {
              System.out.println("Click! Button says - 'Hello World!'");
          }
      }
      
      public class WindowsButton implements Button {
          
          public void render() {
              System.out.println("Windows Button");
              onClick();
          }
      
          public void onClick() {
              System.out.println("Windows Button says - 'Hello World!'");
          }
      }
      
      -------------------------------------------
      
      // Base factory class.
      public abstract class Dialog {
      
          public void renderWindow() {
              // ... other code ...
              Button okButton = createButton();
              okButton.render();
          }
      
          // Subclasses will override this method in order to create specific button objects. 
          public abstract Button createButton();
      }
      
      public class HtmlDialog extends Dialog {
          @Override
          public Button createButton() { return new HtmlButton(); }
      }
      
      public class WindowsDialog extends Dialog {
          @Override
          public Button createButton() { return new WindowsButton(); }
      }
      
      public class Demo {
          private static Dialog dialog;
      
          public static void main(String[] args) {
              configure();
              runBusinessLogic();
          }
      
          // The concrete factory is usually chosen depending on configuration or environment options.
          static void configure() {
              if (System.getProperty("os.name").equals("Windows 10")) {
                  dialog = new WindowsDialog();
              } else {
                  dialog = new HtmlDialog();
              }
          }
      
          // All of the client code should work with factories and products through
          // abstract interfaces. This way it does not care which factory it works
          // with and what kind of product it returns.
          static void runBusinessLogic() {
              dialog.renderWindow();
          }
      }


### Abstract Factory(Factory Of Factories)      
- Abstract Factory solves the problem of creating entire product families without specifying their concrete classes.
- [Source Link](https://refactoring.guru/design-patterns/abstract-factory/java/example#lang-features)       


        ----------1st Product Heirarchy
        public interface Button {
            void paint();
        }
        
        public class MacOSButton implements Button {
            @Override
            public void paint() { System.out.println("You have created MacOSButton."); }
        }                

        public class WindowsButton implements Button {
            @Override
            public void paint() { System.out.println("You have created WindowsButton."); }
        }                
        
        ----------2nd Product Heirarchy
        public interface Checkbox {
            void paint();
        }
        
        public class MacOSCheckbox implements Checkbox {
            @Override
            public void paint() { System.out.println("You have created MacOSCheckbox."); }
        }
        
        public class WindowsCheckbox implements Checkbox {
            @Override
            public void paint() { System.out.println("You have created WindowsCheckbox."); }
        }

        ------------Abstract Factory
        public interface GUIFactory {
            Button createButton();
            Checkbox createCheckbox();
        }
        
        public class MacOSFactory implements GUIFactory {
        
            @Override
            public Button createButton() { return new MacOSButton(); }
        
            @Override
            public Checkbox createCheckbox() { return new MacOSCheckbox(); }
        }
        
        public class WindowsFactory implements GUIFactory {
        
            @Override
            public Button createButton() { return new WindowsButton(); }
        
            @Override
            public Checkbox createCheckbox() { return new WindowsCheckbox(); }
        }
        
        // Factory users don't care which concrete factory they use since they work with
        // factories and products through abstract interfaces.
        
        public class Application {
            private Button button;
            private Checkbox checkbox;
        
            public Application(GUIFactory factory) {
                button = factory.createButton();
                checkbox = factory.createCheckbox();
            }
        
            public void paint() {
                button.paint();
                checkbox.paint();
            }
        }
        
        public class Demo {
        
            private static Application configureApplication() {
                Application app;
                GUIFactory factory;
                String osName = System.getProperty("os.name").toLowerCase();
                if (osName.contains("mac")) {
                    factory = new MacOSFactory();
                    app = new Application(factory);
                } else {
                    factory = new WindowsFactory();
                    app = new Application(factory);
                }
                return app;
            }
        
            public static void main(String[] args) {
                Application app = configureApplication();
                app.paint();
            }
        }
        

### Prototype   
- Use the Prototype Pattern when creating an instance of a given class is either expensive or complicated(for ex. loading object from DB).         
- It provides a mechanism to copy the original object to a new object and then modify it according to our needs, and uses java cloning to copy the object.      


        import java.util.ArrayList;
        import java.util.List;
        
        public class Employees implements Cloneable{
        
        	private List<String> empList;
        	
        	public Employees(){
        		empList = new ArrayList<>();
        	}
        	
        	public Employees(List<String> list){
        		this.empList=list;
        	}
        
        	public void loadData(){
        		//read all employees from database and put into the list
        		empList.add("Pankaj");
        		empList.add("Raj");
        		empList.add("David");
        		empList.add("Lisa");
        	}
        	
        	public List<String> getEmpList() {
        		return empList;
        	}
        
        	@Override
        	public Object clone() throws CloneNotSupportedException{
        			List<String> temp = new ArrayList<String>();
        			for(String s : this.getEmpList()){
        				temp.add(s);
        			}
        			return new Employees(temp);
        	}
        
        	public static void main(String[] args) throws CloneNotSupportedException {
        		Employees emps = new Employees();
        		emps.loadData();
        
        		//Use the clone method to get the Employee object
        		Employees empsNew = (Employees) emps.clone();
        		Employees empsNew1 = (Employees) emps.clone();
        		List<String> list = empsNew.getEmpList();
        		list.add("John");
        		List<String> list1 = empsNew1.getEmpList();
        		list1.remove("Pankaj");
        
        		System.out.println("emps List: "+emps.getEmpList());
        		System.out.println("empsNew List: "+list);
        		System.out.println("empsNew1 List: "+list1);
        	}
        }


### Adapter             
- Converts the interface of a class into another interface the clients expect.     
- Adapter lets classes work together that couldn’t otherwise because of incompatible interfaces.   
- There are actually two kinds of adapters: **object adapters** and **class adapters**. The only difference is that with class adapter we subclass the Target and the Adaptee, while with object adapter we use composition to pass requests to an Adaptee.


        --------------------------Duck
        public interface IDuck {
            void quack();
            void fly();
        }
        
        public class MallardDuck implements IDuck {
            public void quack() {
                System.out.println("Mallard's quack!!");
            }
            public void fly() {
                System.out.println("Mallard soaring in the sky!!");
            }
        }

        --------------------------Penguin
        public interface IPenguin {
            void gak();
            void noFly();
        }

        public class EmperorPenguin implements IPenguin{
            public void gak() {
                System.out.println("Emperor Penguin's gak!!");
            }
            public void noFly() {
                System.out.println("Emperor Penguins can't fly!! Just flapping his wings desperately.");
            }
        }
        
        --------------------------PenguinAdapter
        public class PenguinAdapter implements IDuck {
            IPenguin penguin;
            public PenguinAdapter(IPenguin penguin) {
                this.penguin = penguin;
            }
        
            public void quack() {
                penguin.gak();
            }
        
            public void fly() {
                penguin.noFly();
            }
        }

        public class Runner {
            public Runner() {
            }
        
            public void test(IDuck subject) {
                subject.quack();
                subject.fly();
            }
        
            public static void main(String[] args) {
                Runner runner = new Runner();
                System.out.println("--------Testing the Mallard duck----------");
                IDuck duck = new MallardDuck();
                runner.test(duck);
        
                System.out.println("--------Testing the Wild turkey----------");
                IPenguin penguin = new EmperorPenguin();
                IDuck penguinAdapter = new PenguinAdapter(penguin);
                runner.test(penguinAdapter);
            }
        }

### Composite               
- It allows you to compose objects into tree structures to represent part-whole hierarchies.    
- Composite lets clients treat individual objects and compositions of objects uniformly.   
- The Composite Pattern allows us to build structures of objects in the form of trees that contain both compositions of objects and individual objects as nodes. 
- Using a composite structure, we can apply the same operations over both composites and individual objects. In other words, in most cases we can ignore the differences between compositions of objects and individual objects.            


        public abstract class MenuComponent {
           
        	public void add(MenuComponent menuComponent) { throw new UnsupportedOperationException(); }
        	public void remove(MenuComponent menuComponent) { throw new UnsupportedOperationException(); }
        	public MenuComponent getChild(int i) { throw new UnsupportedOperationException(); }
          
        	public String getName() { throw new UnsupportedOperationException(); }
        	public String getDescription() { throw new UnsupportedOperationException(); }
        	public double getPrice() { throw new UnsupportedOperationException(); }
        	public boolean isVegetarian() { throw new UnsupportedOperationException(); }
          
        	public void print() { throw new UnsupportedOperationException(); }
        }
        
        public class MenuItem extends MenuComponent {
        	String name;
        	String description;
        	boolean vegetarian;
        	double price;
            
        	public MenuItem(String name, String description, boolean vegetarian, double price) { 
        		this.name = name;
        		this.description = description;
        		this.vegetarian = vegetarian;
        		this.price = price;
        	}
          
        	public String getName() {
        		return name;
        	}
          
        	public String getDescription() {
        		return description;
        	}
          
        	public double getPrice() {
        		return price;
        	}
          
        	public boolean isVegetarian() {
        		return vegetarian;
        	}
          
        	public void print() {
        		System.out.print("  " + getName());
        		if (isVegetarian()) System.out.print("(v)");
        		System.out.println(", " + getPrice());
        		System.out.println("     -- " + getDescription());
        	}
        }

        public class Menu extends MenuComponent {
        	ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
        	String name;
        	String description;
          
        	public Menu(String name, String description) {
        		this.name = name;
        		this.description = description;
        	}
         
        	public void add(MenuComponent menuComponent) {
        		menuComponents.add(menuComponent);
        	}
         
        	public void remove(MenuComponent menuComponent) {
        		menuComponents.remove(menuComponent);
        	}
         
        	public MenuComponent getChild(int i) {
        		return (MenuComponent)menuComponents.get(i);
        	}
         
        	public String getName() {
        		return name;
        	}
         
        	public String getDescription() {
        		return description;
        	}
         
        	public void print() {
        		System.out.print("\n" + getName());
        		System.out.println(", " + getDescription());
        		System.out.println("---------------------");
          
        		Iterator<MenuComponent> iterator = menuComponents.iterator();
        		while (iterator.hasNext()) {
        			MenuComponent menuComponent = 
        				(MenuComponent)iterator.next();
        			menuComponent.print();
        		}
        	}
        }

        public class Waitress {
        	MenuComponent allMenus;
         
        	public Waitress(MenuComponent allMenus) {
        		this.allMenus = allMenus;
        	}
         
        	public void printMenu() {
        		allMenus.print();
        	}
        }

        public class MenuTestDrive {
        	public static void main(String args[]) {
        		MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        		MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
        		MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
        		MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");
        		MenuComponent coffeeMenu = new Menu("COFFEE MENU", "Stuff to go with your afternoon coffee");
        		MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
          
        		allMenus.add(pancakeHouseMenu);
        		allMenus.add(dinerMenu);
        		allMenus.add(cafeMenu);
          
        		pancakeHouseMenu.add(new MenuItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs and toast", true, 2.99));
        		pancakeHouseMenu.add(new MenuItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99));
        		pancakeHouseMenu.add(new MenuItem("Blueberry Pancakes", "Pancakes made with fresh blueberries, and blueberry syrup", true, 3.49));
        		pancakeHouseMenu.add(new MenuItem("Waffles", "Waffles with your choice of blueberries or strawberries", true, 3.59));
                
                //DinnerMenu contains individual MenuItem as well as DesertMenu(composite object of individual desert items)
        		dinerMenu.add(new MenuItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99));
        		dinerMenu.add(new MenuItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99));
        		dinerMenu.add(new MenuItem("Soup of the day", "A bowl of the soup of the day, with a side of potato salad", false, 3.29));
        		dinerMenu.add(new MenuItem("Hot Dog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.05));
        		dinerMenu.add(new MenuItem("Steamed Veggies and Brown Rice", "Steamed vegetables over brown rice", true, 3.99));
        		dinerMenu.add(new MenuItem("Pasta", "Spaghetti with marinara sauce, and a slice of sourdough bread", true, 3.89));
           
        		dinerMenu.add(dessertMenu);
          
        		dessertMenu.add(new MenuItem("Apple Pie", "Apple pie with a flakey crust, topped with vanilla icecream", true, 1.59));
        		dessertMenu.add(new MenuItem("Cheesecake", "Creamy New York cheesecake, with a chocolate graham crust", true, 1.99));
        		dessertMenu.add(new MenuItem("Sorbet", "A scoop of raspberry and a scoop of lime", true, 1.89));
        
        		cafeMenu.add(new MenuItem("Veggie Burger and Air Fries", "Veggie burger on a whole wheat bun, lettuce, tomato, and fries", true, 3.99));
        		cafeMenu.add(new MenuItem("Soup of the day", "A cup of the soup of the day, with a side salad", false, 3.69));
        		cafeMenu.add(new MenuItem("Burrito", "A large burrito, with whole pinto beans, salsa, guacamole", true, 4.29));
        		cafeMenu.add(coffeeMenu);
        
        		coffeeMenu.add(new MenuItem("Coffee Cake", "Crumbly cake topped with cinnamon and walnuts", true, 1.59));
        		coffeeMenu.add(new MenuItem("Bagel", "Flavors include sesame, poppyseed, cinnamon raisin, pumpkin", false, 0.69));
        		coffeeMenu.add(new MenuItem("Biscotti", "Three almond or hazelnut biscotti cookies", true, 0.89));
         
        		Waitress waitress = new Waitress(allMenus);
        		waitress.printMenu();
        	}
        }

### Proxy               
- Used to create a representative object that controls access to another object, which may be remote, expensive to create, or in need of securing.    
- It provides a surrogate or placeholder for another object to control access to it.  A few forms are Remote Proxy, Virtual Proxy.  
- A remote proxy acts as a local representative to a remote object. A Remote Object is an object that lives in the heap of a different Java Virtual Machine (or more generally, a remote object that is running in a different address space). A Local representative is an object that you can call local methods on and have them forwarded on to the remote object.   
- Virtual Proxy acts as a representative for an object that may be expensive to create. It often defers the creation of the object until it is needed, it also acts as a surrogate for the object before and while it is being created. After that, the proxy delegates requests directly to the RealSubject.       
-  Proxies delegate all of the real work to some other object. Each proxy method should, in the end, refer to a service object unless the proxy is a subclass of a service.         
    
    
        public interface ThirdPartyYouTubeLib {
            HashMap<String, Video> popularVideos();
            Video getVideo(String videoId);
        }  

        public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {
        
            @Override
            public HashMap<String, Video> popularVideos() {
                connectToServer("http://www.youtube.com");
                return getRandomVideos();
            }
        
            @Override
            public Video getVideo(String videoId) {
                connectToServer("http://www.youtube.com/" + videoId);
                return getSomeVideo(videoId);
            }
        
            private void connectToServer(String server) {
                System.out.print("Connecting to " + server + "... ");
            }
        
            private HashMap<String, Video> getRandomVideos() {
                System.out.print("Downloading populars... ");
                HashMap<String, Video> hmap = new HashMap<String, Video>();
                hmap.put("catzzzzzzzzz", new Video("sadgahasgdas", "Catzzzz.avi"));
                return hmap;
            }
        
            private Video getSomeVideo(String videoId) {
                System.out.print("Downloading video... ");
                System.out.print("Done!" + "\n");
                return video;
            }
        }
        
        public class Video {
            public String id;
            public String title;
            public String data;
        
            Video(String id, String title) {
                this.id = id;
                this.title = title;
                this.data = "Random video.";
            }
        }
        
        // Caching Proxy enables caching of Youtube videos
        public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {
            private ThirdPartyYouTubeLib youtubeService;
            private HashMap<String, Video> cachePopular = new HashMap<String, Video>();
            private HashMap<String, Video> cacheAll = new HashMap<String, Video>();
        
            public YouTubeCacheProxy() {
                this.youtubeService = new ThirdPartyYouTubeClass();
            }
        
            @Override
            public HashMap<String, Video> popularVideos() {
                if (cachePopular.isEmpty()) {
                    cachePopular = youtubeService.popularVideos();
                } else {
                    System.out.println("Retrieved list from cache.");
                }
                return cachePopular;
            }
        
            @Override
            public Video getVideo(String videoId) {
                Video video = cacheAll.get(videoId);
                if (video == null) {
                    video = youtubeService.getVideo(videoId);
                    cacheAll.put(videoId, video);
                } else {
                    System.out.println("Retrieved video '" + videoId + "' from cache.");
                }
                return video;
            }
        
            public void reset() {
                cachePopular.clear();
                cacheAll.clear();
            }
        }
        
        public class YouTubeDownloader {
            private ThirdPartyYouTubeLib api;
        
            public YouTubeDownloader(ThirdPartyYouTubeLib api) {
                this.api = api;
            }
        
            public void renderVideoPage(String videoId) {
                Video video = api.getVideo(videoId);
                System.out.println("\n-------------------------------");
                System.out.println("Video page (imagine fancy HTML)");
                System.out.println("ID: " + video.id);
                System.out.println("Title: " + video.title);
                System.out.println("Video: " + video.data);
                System.out.println("-------------------------------\n");
            }
        
            public void renderPopularVideos() {
                HashMap<String, Video> list = api.popularVideos();
                System.out.println("\n-------------------------------");
                System.out.println("Most popular videos on YouTube (imagine fancy HTML)");
                for (Video video : list.values()) {
                    System.out.println("ID: " + video.id + " / Title: " + video.title);
                }
                System.out.println("-------------------------------\n");
            }
        }
        
        public class Demo {
            public static void main(String[] args) {
                YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTubeClass());
                YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy());
        
                long naive = test(naiveDownloader);
                long smart = test(smartDownloader);
                System.out.print("Time saved by caching proxy: " + (naive - smart) + "ms");
        
            }
        
            private static long test(YouTubeDownloader downloader) {
                long startTime = System.currentTimeMillis();
        
                // User behavior in our app:
                downloader.renderPopularVideos();
                downloader.renderVideoPage("catzzzzzzzzz");
                downloader.renderPopularVideos();
                downloader.renderVideoPage("dancesvideoo");
                // Users might visit the same page quite often.
                downloader.renderVideoPage("catzzzzzzzzz");
                downloader.renderVideoPage("someothervid");
        
                long estimatedTime = System.currentTimeMillis() - startTime;
                System.out.print("Time elapsed: " + estimatedTime + "ms\n");
                return estimatedTime;
            }
        }
        
### Flyweight
- Use the Flyweight Pattern when one instance of a class can be used to provide many “virtual instances.”
- Flyweight can be recognized by a creation method that returns cached objects instead of creating new.         


        public class Tree {
            private int x;
            private int y;
            private TreeType type;
        
            public Tree(int x, int y, TreeType type) {
                this.x = x;
                this.y = y;
                this.type = type;
            }
        
            public void draw(Graphics g) {
                type.draw(g, x, y);
            }
        }
        
        -- Flyweight object
        public class TreeType {
            private String name;
            private Color color;
            private String otherTreeData;
        
            public TreeType(String name, Color color, String otherTreeData) {
                this.name = name;
                this.color = color;
                this.otherTreeData = otherTreeData;
            }
        
            public void draw(Graphics g, int x, int y) {
                g.setColor(Color.BLACK);
                g.fillRect(x - 1, y, 3, 5);
                g.setColor(color);
                g.fillOval(x - 5, y - 10, 10, 10);
            }
        }
        
        -- Factory holding the TreeType flyweight objects
        public class TreeFactory {
            static Map<String, TreeType> treeTypes = new HashMap<>();
        
            public static TreeType getTreeType(String name, Color color, String otherTreeData) {
                TreeType result = treeTypes.get(name);
                if (result == null) {
                    result = new TreeType(name, color, otherTreeData);
                    treeTypes.put(name, result);
                }
                return result;
            }
        }
        
        public class Forest extends JFrame {
            private List<Tree> trees = new ArrayList<>();
        
            public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
                TreeType type = TreeFactory.getTreeType(name, color, otherTreeData);
                Tree tree = new Tree(x, y, type);
                trees.add(tree);
            }
        
            @Override
            public void paint(Graphics graphics) {
                for (Tree tree : trees) {
                    tree.draw(graphics);
                }
            }
        }
        
        public class Demo {
            static int CANVAS_SIZE = 500;
            static int TREES_TO_DRAW = 1000000;
            static int TREE_TYPES = 2;
        
            public static void main(String[] args) {
                Forest forest = new Forest();
                for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
                    forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                            "Summer Oak", Color.GREEN, "Oak texture stub");
                    forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                            "Autumn Oak", Color.ORANGE, "Autumn Oak texture stub");
                }
                forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
                forest.setVisible(true);
        
                System.out.println(TREES_TO_DRAW + " trees drawn");
                System.out.println("---------------------");
                System.out.println("Memory usage:");
                System.out.println("Tree size (8 bytes) * " + TREES_TO_DRAW);
                System.out.println("+ TreeTypes size (~30 bytes) * " + TREE_TYPES + "");
                System.out.println("---------------------");
                System.out.println("Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) +
                        "MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024) + "MB)");
            }
        
            private static int random(int min, int max) {
                return min + (int) (Math.random() * ((max - min) + 1));
            }
        }
    
### Facade              
- It provides a simplified (but limited) interface to a complex system of classes, library or framework.            
- It provides a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use. It alters an interface, but for a different reason: to simplify the interface.                
- A facade not only simplifies an interface, it decouples a client from a subsystem of components.               
- **Facades and adapters may wrap multiple classes, but a facade’s intent is to simplify, while an adapter’s is to convert the interface to something different.**            


        public class VideoFile {
            private String name;
            private String codecType;
        
            public VideoFile(String name) {
                this.name = name;
                this.codecType = name.substring(name.indexOf(".") + 1);
            }
        
            public String getCodecType() {
                return codecType;
            }
        
            public String getName() {
                return name;
            }
        }
        
        public interface Codec {
        }
        
        public class MPEG4CompressionCodec implements Codec {
            public String type = "mp4";
        }
        
        public class OggCompressionCodec implements Codec {
            public String type = "ogg";
        }
        
        public class CodecFactory {
            public static Codec extract(VideoFile file) {
                String type = file.getCodecType();
                if (type.equals("mp4")) {
                    System.out.println("CodecFactory: extracting mpeg audio...");
                    return new MPEG4CompressionCodec();
                }
                else {
                    System.out.println("CodecFactory: extracting ogg audio...");
                    return new OggCompressionCodec();
                }
            }
        }
        
        public class BitrateReader {
            public static VideoFile read(VideoFile file, Codec codec) {
                System.out.println("BitrateReader: reading file...");
                return file;
            }
        
            public static VideoFile convert(VideoFile buffer, Codec codec) {
                System.out.println("BitrateReader: writing file...");
                return buffer;
            }
        }
        
        public class AudioMixer {
            public File fix(VideoFile result){
                System.out.println("AudioMixer: fixing audio...");
                return new File("tmp");
            }
        }
        
        public class VideoConversionFacade {
            public File convertVideo(String fileName, String format) {
                System.out.println("VideoConversionFacade: conversion started.");
                VideoFile file = new VideoFile(fileName);
                Codec sourceCodec = CodecFactory.extract(file);
                Codec destinationCodec;
                if (format.equals("mp4")) {
                    destinationCodec = new MPEG4CompressionCodec();
                } else {
                    destinationCodec = new OggCompressionCodec();
                }
                VideoFile buffer = BitrateReader.read(file, sourceCodec);
                VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
                File result = (new AudioMixer()).fix(intermediateResult);
                System.out.println("VideoConversionFacade: conversion completed.");
                return result;
            }
        }
        
        public class Demo {
            public static void main(String[] args) {
                VideoConversionFacade converter = new VideoConversionFacade();
                File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
            }
        }
        
        
### Bridge     
- Use the Bridge Pattern to vary not only your implementations, but also your abstractions.         
    
        
        public abstract class TV {
        	public abstract void on();
        	public abstract void off();
        	public abstract void tuneChannel(int channel);
        	public abstract int getChannel(); 
        }
        
        public class Sony extends TV {
        	int station = 0;
        	public void on() {
        		System.out.println("Turning on the Sony TV");
        	}
        	public void off() {
        		System.out.println("Turning off the Sony TV");
        	}
        	public void tuneChannel(int channel) {
        		this.station = channel;
        		System.out.println("Set the Sony TV station to " + this.station);
        	}
        	public int getChannel() {
        		return station;
        	}
        }
        
        public class LG extends TV {
        	int channel = 1;
        	public void on() {
        		System.out.println("Turning on the LG TV");
        	}
        	public void off() {
        		System.out.println("Turning off the LG TV");
        	}
        	public void tuneChannel(int channel) {
        		this.channel = channel;
        		System.out.println("Set the LG TV Channel to " + this.channel);
        	}
        	public int getChannel() {
        		return channel;
        	}
        }
                
        public class TVFactory {
        	public TV getTV(String type) throws Exception {
        		if (type.equals("LG")) {
        			return new LG();
        		} else if (type.equals("Sony")) {
        			return new Sony();
        		} else {
        			throw new Exception("Invalid TV Type");
        		}
        	}
        }
        
        //RemoteControl abstract class, acts as a bridge between Remotes and different types of TVs
        public abstract class RemoteControl {
        	TV tv;
        	TVFactory tvFactory;
        	public RemoteControl(TVFactory tvFactory) {
        		this.tvFactory = tvFactory;
        	}
        	public void on() {
        		this.tv.on();
        	}
        	public void off() {
        		this.tv.off();
        	}
        	public void setChannel(int channel) {
        		tv.tuneChannel(channel);
        	}
        	public int getChannel() {
        		return tv.getChannel();
        	}
        	public void setTV(String type) {
        		try {
        			tv = tvFactory.getTV(type);
        		} catch (Exception e) {
        			System.out.println(e);
        		}
        	}
        }
        
        public class SpecialRemote extends RemoteControl {
        	public SpecialRemote(TVFactory tvFactory) {
        		super(tvFactory);
        	}
        	public void up() {
        		int channel = this.getChannel();
        		this.setChannel(channel+1);
        	}
        	public void down() {
        		int channel = this.getChannel();
        		this.setChannel(channel-1);
        	}
        }
        
        public class GenericRemote extends RemoteControl {
        	public GenericRemote(TVFactory tvFactory) {
        		super(tvFactory);
        	}
        	public void nextChannel() {
        		int channel = this.getChannel();
        		this.setChannel(channel+1);
        	}
        	public void prevChannel() {
        		int channel = this.getChannel();
        		this.setChannel(channel-1);
        	}
        }
        
        public class Client {
        	public static void main(String[] args) {
        		TVFactory tvFactory = new TVFactory();
        		SpecialRemote remoteSony = new SpecialRemote(tvFactory);
        		System.out.println("Connect your remote to the TV");
        		remoteSony.setTV("Sony");
        		remoteSony.on();
        		remoteSony.up();
        		remoteSony.down();
        		remoteSony.off();
        		
        		GenericRemote remoteLG = new GenericRemote(tvFactory);
        		System.out.println("Connect your remote to the TV");
        		remoteLG.setTV("LG");
        		remoteLG.on();
        		remoteLG.nextChannel();
        		remoteLG.prevChannel();
        		remoteLG.off();
        	}
        }

### Decorator               
- Using decorators you can wrap objects countless number of times since both target objects and decorators follow the same interface. 
- The resulting object will get a stacking behavior of all wrappers.              
- Attaches additional responsibilities to an object dynamically.  
- Decorator provides a flexible alternative to subclassing for extending functionality.  


        public abstract class Pizza {
            String description = "Basic Pizza";
        
            public String getDescription() { return description; }
            abstract double price();
        }
        
        public class StuffedCrust extends Pizza {
            private String description;
        
            public StuffedCrust() { this.description = "Stuffed crust pizza"; }
        
            @Override
            public String getDescription() { return description; }
        
            public double price() { return 200.0; }
        }
        
        public class ThinCrust extends Pizza {
            private String description;
        
            public ThinCrust() { this.description  = "Thin crust pizza"; }
        
            @Override
            public String getDescription() { return description; }
        
            public double price() { return 100.0; }
        }
        
        ------------Decorator
        public abstract class PizzaDecorator extends Pizza {
            Pizza pizza;
            public abstract String getDescription();
        }
        
        public class Capsicum extends PizzaDecorator {
            public Capsicum(Pizza pizza) {
                this.pizza = pizza;
            }
        
            @Override
            public String getDescription() { return pizza.getDescription() + " + Capcsicum"; }
        
            @Override
            public double price() { return 25.5 + pizza.price(); }
        }
        
        public class Cheese extends PizzaDecorator {
            public Cheese(Pizza pizza) {
                this.pizza = pizza;
            }
        
            @Override
            public String getDescription() { return pizza.getDescription() + " + Cheese"; }
        
            @Override
            public double price() { return 50.5 + pizza.price(); }
        }

        public class Olive extends PizzaDecorator {
            public Olive(Pizza pizza) { this.pizza = pizza; }
        
            @Override
            public String getDescription() { return pizza.getDescription() + " + Olive"; }
        
            @Override
            public double price() { return 30.0 + pizza.price(); }
        }

        public class Runner {
            public static void main(String[] args) {
                // Trying to make a thin-crust Pizza with olives, capsicum, extra cheese!!
        
                Pizza pizza = new ThinCrust();
                pizza = new Olive(pizza);
                pizza = new Capsicum(pizza);
                pizza = new Cheese(pizza);
                System.out.println(String.format("%s [Total price: %s]",
                        pizza.getDescription(), pizza.price()));
            }
        }

### Template                
-- It defines the skeleton of an algorithm in a method, deferring some steps to subclasses and lets subclasses redefine certain steps of an algorithm without changing the algorithm’s structure.   
-- A hook is a method that is declared in the abstract class, but only given an empty or default implementation. This gives subclasses the ability to “hook into” the algorithm at various points, if they wish; a subclass is also free to ignore the hook.

        -------------------MilkShakeTemplate
        public abstract class MilkShakeTemplate {
            public void makeAwesomeShake() {
                addMilk();
                addBaseIngredients();
                shakeIt();
                if (needToppings()) {           // This is a hook method
                    addToppings();
                }
            }
        
            // abstract methods follow Hollywood Principle: MilkShakeTemplate(high-level class) will call implementations of these method like in FruitMilkShake and FlavouredMilkShkae(low-level)
            public abstract void addBaseIngredients();
            public abstract void addToppings();
        
            private void addMilk() {
                System.out.println("Adding Milk");
            }
        
            private void shakeIt() {
                System.out.println("Shaking it!!");
            }
        
            public boolean needToppings() {
                return true;
            }
        }

        public class FlavouredMilkShake extends MilkShakeTemplate{
            public void addBaseIngredients() {
                System.out.println("Adding artificial flavouring");
            }
        
            public void addToppings() {
                System.out.println("Adding toppings");
            }
        }

        public class FruitMilkShake extends MilkShakeTemplate {
            public void addBaseIngredients() {
                System.out.println("Adding fresh fruits");
            }
        
            public void addToppings() {
                System.out.println("Adding toppings");
            }
        
            @Override
            public boolean needToppings() {
                return false;
            }
        }

        -------------------Runner
        public class Runner {
            public static void main(String[] args) {
                MilkShakeTemplate fruitShake = new FruitMilkShake();
                MilkShakeTemplate flavouredShake = new FlavouredMilkShake();
                fruitShake.makeAwesomeShake();
                flavouredShake.makeAwesomeShake();
            }
        }

### Mediator                


### Chain Of Responsibility             


### Observer                
- Defines one-to-many dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically.  
- Strive for loosely coupled designs between objects that interact.  
- Follows a IPublisher-Subscriber model  

        
        ---------------------Subsriber
        public interface ISubscriber {
            void onUpdate(Integer runs);
        }
        
        public class Cricbuzz implements ISubscriber {
            Integer totalScore = 0;
            Integer overs = 0;
        
            IPublisher publisher;
        
            public Cricbuzz(IPublisher publisher) {
                this.publisher = publisher;
                publisher.addListerner(this);
            }
        
            @Override
            public void onUpdate(Integer runs) {
                if (runs == -1) {
                    totalScore = 0;
                    overs = 0;
                    return;
                }
        
                overs++;
                totalScore += runs;
                System.out.println(String.format("CRICBUZZ: Total score: %d | Overs: %d| Run rate: %.2f(This over: %d).", totalScore, overs,
                        (double) totalScore/overs, runs));
            }
        }

        public class GoogleUpdates implements ISubscriber {
            Integer totalScore = 0;
            Integer overs = 0;
        
            IPublisher publisher;
        
            public GoogleUpdates(IPublisher publisher) {
                this.publisher = publisher;
                publisher.addListerner(this);
            }
        
            @Override
            public void onUpdate(Integer runs) {
                if (runs == -1) {
                    totalScore = 0;
                    overs = 0;
                    return;
                }
                overs++;
                totalScore += runs;
                System.out.println(String.format("GOOGLE: %d runs in %d overs(This over: %d).", totalScore, overs, runs));
            }
        }

        -----------------------Publisher
        public interface IPublisher {
        
            void addListerner(ISubscriber subscriber);
            void removeListerner(ISubscriber subscriber);
            void notifyListerners();
            void publish(Integer overs);
        }
        
        public class CricketMatchUpdate implements IPublisher {
        
            List<ISubscriber> subscribers;
            Integer runsPerOVer;
        
            public CricketMatchUpdate() {
                this.subscribers = new ArrayList<>();
            }
        
            public void addListerner(ISubscriber subscriber) {
                subscribers.add(subscriber);
            }
        
            public void removeListerner(ISubscriber subscriber) {
                subscribers.remove(subscriber);
            }
        
            public void notifyListerners() {
                subscribers.forEach(subscriber -> subscriber.onUpdate(runsPerOVer));
            }
        
            private void update(Integer runs) {
                this.runsPerOVer = runs;
                notifyListerners();
            }
        
            public void publish(Integer overs) {
                update(-1);
                Random random = new Random();
                int max = 5; // Test match
                if (overs <= 20) {
                 //T20 match
                    max = 20;
                } else if (overs <= 50){
                 // ODI match
                    max = 10;
                }
                for (int i = 1; i <= overs; i++) {
                    try {
                        Thread.sleep(200);
                        update(random.nextInt(max+1));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        -------------------Runner
        public class Runner {
            public static void main(String[] args) {
                IPublisher cricketScore = new CricketMatchUpdate();
                // Adding subscribers to the Cricket Updates publisher
                ISubscriber google = new GoogleUpdates(cricketScore);
                ISubscriber cricbuzz = new Cricbuzz(cricketScore);
        
                // Start the match
                System.out.println("--------------------T-20 match updates--------------------");
                cricketScore.publish(20);
                System.out.println("--------------------ODI match updates--------------------");
                cricketScore.publish(50);
                System.out.println("--------------------Test match updates--------------------");
                cricketScore.publish(120);
        
            }
        }



### Strategy                
- Defines a family of algorithms, encapsulates each one and makes them interchangeable.  
- Strategy lets the algorithm vary independently from clients that use it.  
> In the example code, each GroceryStore **HAS-A** Billing and Payment strategy.


        --------------------IBilling 
        public interface IBilling {
            void generateBill();
        }
        
        public class ManualBilling implements IBilling {
            public void generateBill(){
                System.out.println("Bill generated Manually!!");
            }
        }

        public class ScanBilling implements IBilling {
            public void generateBill(){
                System.out.println("Bill generated through QR Scan!!");
            }
        }

        --------------------IPayment
        public interface IPayment {
            void processPayment();
        }
        
        public class UpiPayment implements IPayment {
            public void processPayment() {
                System.out.println("Making UPI payment");
            }
        }

        public class CardPayment implements IPayment {
            public void processPayment() {
                System.out.println("Making Card Payment");
            }
        }

        public class CashPayment implements IPayment {
            public void processPayment() {
                System.out.println("Making Cash payment");
            }
        }

        --------------------GroceryStoreAbstract
        public abstract class GroceryStore {
            IBilling billingStrategy;
            IPayment paymentStrategy;
        
            abstract void catalog();
        
            public GroceryStore() { }
        
            public void generateBill(){
                billingStrategy.generateBill();
            }
        
            public void processPayment() {
                paymentStrategy.processPayment();
            }
        
            public void shop() {
                catalog();
                System.out.println("Begin shopping!!");
                generateBill();
                processPayment();
            }
        }

        public class AmazonFresh extends GroceryStore{
            public AmazonFresh() {
                billingStrategy = new ManualBilling();
                paymentStrategy = new CardPayment();
            }
        
            public void catalog() {
                System.out.println("Amazon Fresh Catalogue!!");
            }
        }

        public class RelianceFresh extends GroceryStore {
            public RelianceFresh() {
                billingStrategy = new ScanBilling();
                paymentStrategy = new UpiPayment();
            }
        
            public void catalog() {
                System.out.println("Reliance Fresh Catalogue!!");
            }
        }

        --------------------Runner
        public class Runner {
            public static void main(String[] args) {
                System.out.println("----Shop with Amazon----");
                GroceryStore amz = new AmazonFresh();
                amz.shop();
                System.out.println("----Shop with Reliance----");
                GroceryStore rel = new RelianceFresh();
                rel.shop();
            }
        }

### Command             


### State               


### Visitor             


### Interpreter             


### Iterator                


### Memento             

        