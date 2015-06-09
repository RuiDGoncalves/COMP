
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Printer {
	private static Graph grafo;
	private static ArrayList<Links> links; 
	private static ArrayList<Nodes> nodes;
	
	
	public Printer(Graph grafo, ArrayList<Links> links, ArrayList<Nodes> nodes){
		this.grafo = grafo;
		this.links = links;
		this.nodes = nodes;
		
	}

	public static void main( String[] args ){			
	}

	public static void createFile(){
		try {
			int i = 4;
			String filename = "Teste", extension =".dot";
			File file= new File(filename + extension);

			if (file.createNewFile()){
				writeToFile(file,grafo, links , nodes);
			}else{
				String filename_parts [];
				filename_parts = file.getName().toString().split("\\.");
				File file2  = new File(filename_parts[0] + i + extension);
				file2.createNewFile();
				writeToFile(file2,grafo, links , nodes);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void writeToFile(File file,Graph grafo, ArrayList<Links> links, ArrayList<Nodes> nodes){
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			String filename_parts [];
			filename_parts = file.getName().toString().split("\\.");
			bw.write("Graph " + filename_parts[0] + " {\n");
				//System.out.println("Grafo: " +  grafo.getNodes().keySet());
                for(int i = 0; i< grafo.getLinks().size(); i++){
                	String name = "";
                	if(i == grafo.getLinks().size()-1){
                		 System.out.println("Source: " +  grafo.getLinks().get(i).getSource());
                         bw.write(nodes.get(grafo.getLinks().get(i).getSource()).getName());
                         bw.write(" -- ");
                         System.out.println("Target: " +  grafo.getLinks().get(i).getTarget());
                         bw.write(nodes.get(grafo.getLinks().get(i).getTarget()).getName() + ";\n");
                         System.out.println("Val: " +  grafo.getLinks().get(i).getValue());
                		bw.write("}");
                		break;
                		 }
                	
                System.out.println("Source: " +  grafo.getLinks().get(i).getSource());
                bw.write(nodes.get(grafo.getLinks().get(i).getSource()).getName());
                bw.write(" -- ");
                System.out.println("Target: " +  grafo.getLinks().get(i).getTarget());
                bw.write(nodes.get(grafo.getLinks().get(i).getTarget()).getName() + ";\n");
                System.out.println("Val: " +  grafo.getLinks().get(i).getValue());
                }

        for(int j = 0; j< grafo.getLinks().size(); j++){
                System.out.println("id: " +  nodes.get(j).getId());
                System.out.println("name: " +  nodes.get(j).getName());
                System.out.println("group: " +  nodes.get(j).getGroup());
        }

			bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
