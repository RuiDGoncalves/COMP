
import graph.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public class ParseDot {
	private Graph grafo;
	private String[] color = {"purple","darkolivegreen","darkorange","aliceblue"
		,"antiquewhite","aquamarine","beige","violetred4","powderblue","blueviolet"
		,"brown","burlywodd","cadetblue","chartreuse","chocolate","coral"
		,"cornflowerblue","conrsilk","crimson","cyan","darkengoldenrod"
		,"drakgreen","darkorchid","darksalmon","forestgreen","steelblue1"
		,"darkturquoise","deeppink","deeppink4","deepskyblue","deepskyblue4"
		,"dodgerblue","dodgerblue4","firebrick1","forestgreen","gold"};


	public ParseDot(Graph grafo){
		this.grafo = grafo;		
	}
	public void createFile(){
		try {
			String filename = "DotView", extension =".dot";
			File file= new File(filename + extension);

			if (file.createNewFile()){
				writeToFile(file);
			}else{
				String filename_parts [];
				filename_parts = file.getName().toString().split("\\.");
				File file2  = new File(filename_parts[0] + extension);
				file2.createNewFile();
				writeToFile(file2);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void writeToFile(File file){
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			String filename_parts [];
			filename_parts = file.getName().toString().split("\\.");
			bw.write("Graph " + filename_parts[0] + " {\n");
			for(int i = 0; i< grafo.getLinks().size(); i++){

				bw.write(grafo.getLinks().get(i).getSource().getName());
				bw.write(" -- ");
				bw.write(grafo.getLinks().get(i).getTarget().getName());
				bw.write(" [label = " + grafo.getLinks().get(i).getValue() + " penwidth = " + (double)grafo.getLinks().get(i).getValue()/50 + "];\n");

				if(i == grafo.getLinks().size()-1){
					List<Vertex> vStars = grafo.getNoEstrela();
					for(int j = 0; j < vStars.size();j++){
						bw.write(vStars.get(j).getName() + "[shape = tripleoctagon];\n");	
					}
					coloring(file,bw);
					bw.write("}");
				}
			} 
			bw.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void coloring(File file, BufferedWriter bw) {
		try {

			Iterator it = grafo.getSubgraphs().entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				Integer group = ((Integer) pair.getKey());
				Subgraph subgrafo = ((Subgraph) pair.getValue());

				Iterator it2 = subgrafo.getNodes().entrySet().iterator();
				while(it2.hasNext())
				{
					Map.Entry pair2 = (Map.Entry) it2.next();
					String name = ((String) pair2.getKey());
					bw.write(name + "[ style = filled color = " + color[group] + "];\n");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
