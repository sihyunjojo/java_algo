import java.io.IOException;

@FunctionalInterface
public interface Func {
    void apply() throws IOException;
}
