package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Beta extends Papa {


    /* // Subclass method tries to throw a checked exception*/

    // Compiler error: Unhandled exception type IOException
//    @Override
//    void doSomething() throws IOException { // Compiler error: Unhandled exception type IOException
//        // Some implementation
//    }

    @Override
    void doSomethingMore() {
        // Some implementation that may cause a runtime exception
        throw new RuntimeException("Unchecked Exception Thrown by Subclass");
    }


    @Override
    void doSomethingNew() throws IOException {
        // Some implementation that may throw IOException
    }

    // Subclass method can throw a subclass exception
    void doSomethingDifferent() throws FileNotFoundException {
        // Some implementation that may throw FileNotFoundException
    }

    @Override
    // Subclass method can choose not to throw any exceptions
    void doSomethingElse()  {
        // Some implementation without throwing any exceptions
    }
}
