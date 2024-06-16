package arrays;

public  final class Employee {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employee(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
