import java.io.*;
import java.util.ArrayList;

public class ThreadStaffId extends Thread{

    ArrayList<String> staffIdArray = new ArrayList<>();

    @Override
    public void run() {
        Thread threadStaffList = new Thread() {
            @Override
            public void run() {
                File file = new File("data\\staff.txt");

                Reader reader = null;
                try {
                    reader = new FileReader(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                BufferedReader br = new BufferedReader(reader);

                String line = null;
                while(true) {
                    try {
                        if (!((line = br.readLine()) != null)) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    staffIdArray.add(line);
                }
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                File html = new File("web\\home.html");
                try {
                    String htmlCode = "<!doctype html>\n" +
                            "<html lang=\"en\">\n" +
                            "  <head>\n" +
                            "    <!-- Required meta tags -->\n" +
                            "    <meta charset=\"utf-8\">\n" +
                            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                            "\n" +
                            "    <!-- Bootstrap CSS -->\n" +
                            "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
                            "\n" +
                            "    <title>MSPR 6.1</title>\n" +
                            "  </head>\n" +
                            "  <body>\n" +
                            "    <div class=\"container\">\n" +
                            "        <div class=\"row\">\n" +
                            "          <div class=\"col-sm\">\n" +
                            "          </div>\n" +
                            "          <div class=\"col-sm\"  style=\"color:#379EC1\">\n" +
                            "            <h1>Liste des agents :</h1>\n" +
                            "            <br></br>\n" +
                            "            <ul class=\"list-group list-group-flush\"  style=\"color:#659224; text-align: center;\">";
                    for(int i = 0; i < staffIdArray.size(); i ++){
                        htmlCode += "<li class=\"list-group-item\"><a href=\"#\" style=\"text-decoration:none; color:#659224;\">" + staffIdArray.get(i) + "</a></li>";
                    }
                    htmlCode += "              </ul>          </div>\n" +
                            "          <div class=\"col-sm\">\n" +
                            "          </div>\n" +
                            "        </div>\n" +
                            "      </div>\n" +
                            "    \n" +
                            "\n" +
                            "    <!-- Optional JavaScript -->\n" +
                            "    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\n" +
                            "    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
                            "    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
                            "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" +
                            "  </body>";
                    FileWriter fileWriter = new FileWriter(html);
                    fileWriter.write(htmlCode);
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public ArrayList<String> getStaffIdArray() {
        return staffIdArray;
    }
}
