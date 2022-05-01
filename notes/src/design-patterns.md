## GOF Design Patterns:  

## Topics:

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


### Composite               


### Proxy               


### Flyweight               


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
                // ...
            }
        }
        
        
### Bridge              


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


### Mediator                


### Chain Of Responsibility             


### Observer                


### Strategy                


### Command             


### State               


### Visitor             


### Interpreter             


### Iterator                


### Memento             

        