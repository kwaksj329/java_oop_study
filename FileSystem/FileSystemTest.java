import filesystem.*;

public class FileSystemTest {
    public static void main(String[] args) {
        Folder root = new Folder("root");
        Folder system = new Folder("system");
        Folder lib = new Folder("libraries");
        Folder util = new Folder("utilities");
        Folder kyung = new Folder("Kyung");
        root.add(system);
        root.add(kyung);
        system.add(lib);
        system.add(util);
        File tmp = new File("tmp.txt", 100);
        File ogl = new File("libOpenGL.lib", 10000);
        File vtk = new File("libVTK.lib", 12000);
        File lec1 = new File("lecture1.ppt", 150);
        File lec2 = new File("lecture2.ppt", 230);
        root.add(tmp);
        lib.add(ogl);
        lib.add(vtk);
        kyung.add(lec1);
        kyung.add(lec2);
        root.print("");
        Node n = root.search("lecture1.ppt");
        System.out.println(n.getName() + " has been found.");

    }

}
