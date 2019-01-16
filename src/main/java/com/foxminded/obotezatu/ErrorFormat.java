package com.foxminded.obotezatu;

import java.io.FileWriter;
import java.io.IOException;

public class ErrorFormat {

	public static void divisionFormatterFormat() {
		Division division = new Division();
		DivisionFormatter divisionFormatter = new DivisionFormatter();
		StringBuilder expectedFormattedResult = new StringBuilder();
		expectedFormattedResult.append("_78945 | 4\n");
		expectedFormattedResult.append(" 4     |--------\n");
		expectedFormattedResult.append(" --    | 19736\n");
		expectedFormattedResult.append(" _38\n");
		expectedFormattedResult.append("  36\n");
		expectedFormattedResult.append("  --\n");
		expectedFormattedResult.append("  _29\n");
		expectedFormattedResult.append("   28\n");
		expectedFormattedResult.append("   --\n");
		expectedFormattedResult.append("   _14\n");
		expectedFormattedResult.append("    12\n");
		expectedFormattedResult.append("    --\n");
		expectedFormattedResult.append("    _25\n");
		expectedFormattedResult.append("     24\n");
		expectedFormattedResult.append("     --\n");
		expectedFormattedResult.append("     1");
		try(FileWriter writer = new FileWriter("expected.txt", true))
        {
            //writer.write(divisionFormatter.format(division.divide(78945, 4)));
            writer.write(expectedFormattedResult.toString());

        }
		catch(IOException ex){
            
            System.out.println(ex.getMessage());
        }
		try(FileWriter writer2 = new FileWriter("actual.txt", false))
        {
            writer2.write(divisionFormatter.format(division.divide(78945, 4)));
           // writer2.write(expectedFormattedResult.toString());

        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }
		System.out.println("File is written");
	}
}
