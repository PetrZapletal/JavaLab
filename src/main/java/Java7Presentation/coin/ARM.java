package Java7Presentation.coin;

import java.io.IOException;
import java.lang.AutoCloseable;

public class ARM {
	
    public static void main(String[] args)
    {
    	ARM outer = new ARM();
    	
    	//no ';' after last one
        try (
        		T t1 = outer.new T("1");
        		T t2 = outer.new T("2");
        		T t3 = outer.new T("3")
        )
        {
            System.out.println("Try begin");
            t1.doSomething();
            t2.doSomething();
            t3.doSomething();
            System.out.println("Try end");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.println("Finally");
            /*
			try {
				tX.close();
			} catch (Exception e) {
				...
			}
			*/
            
            
        }
    }
    
    
	public class T implements AutoCloseable {
		
		public String name;

		T (String name){
			this.name = name;
			System.out.println(this.toString() + ":" + name + ":contructor");
		}

		@Override
		public void close() throws IOException {
			if(name.equals("2") ){
				throw new RuntimeException("T2 fails");
			}
			
			if(name.equals("3") ){
				throw new RuntimeException("T3 fails");
			}
						
			System.out.println(this.toString() + ":" + name + ":close");
		}
		
		public void doSomething(){
			/*
			if(name.equals("2")){
				throw new RuntimeException("T2 fails");
			}
			*/			
			
			System.out.println(this.toString() + ":" + name + ":doSomething");
		}
	}    
}
