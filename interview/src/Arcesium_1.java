
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class Arcesium_1 {

    class Company {
        String name;
        String basename;

        public String getName() {
            return name;
        }

        public String getBasename() {
            return basename;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Company{");
            sb.append("name='").append(name).append('\'');
            sb.append(", basename='").append(basename).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
    class Geo {
        String lat;
        String lng;

        public String getLat() {
            return lat;
        }

        public String getLng() {
            return lng;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Geo{");
            sb.append("lat='").append(lat).append('\'');
            sb.append(", lng='").append(lng).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
    class Address {
        String street;
        String suite;
        String city;
        String zipcode;
        Geo geo;

        public String getStreet() {
            return street;
        }

        public String getSuite() {
            return suite;
        }

        public String getCity() {
            return city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public Geo getGeo() {
            return geo;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Address{");
            sb.append("street='").append(street).append('\'');
            sb.append(", suite='").append(suite).append('\'');
            sb.append(", city='").append(city).append('\'');
            sb.append(", zipcode='").append(zipcode).append('\'');
            sb.append(", geo=").append(geo);
            sb.append('}');
            return sb.toString();
        }
    }

    class SampleResponse {
        Integer id;
        String name;
        String username;
        String email;
        String website;
        Address address;
        Company company;

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }

        public String getWebsite() {
            return website;
        }

        public Address getAddress() {
            return address;
        }

        public Company getCompany() {
            return company;
        }

        public String getValue(String criteria) {
            String levelOne = criteria;
            String result = null;
            switch (levelOne) {
                case "name" : result = getName(); break;
                case "username" : result = getUsername(); break;
                case "email" : result = getEmail(); break;
                case "website" : result = getWebsite(); break;
            }

            return result;

        }

        public String getTwo(String criteria) {
            String [] arr = criteria.split("\\.");
            String result = null;

            String one = arr[0];
            String two = arr[1];

            if (arr.length==2)
            {
                switch (one) {
                    case "address" : result = getAddr(getAddress(), two); break;
                    case "company" : result = getComp(getCompany(), two); break;

                }
            }
            else if(arr.length==3)
            {
                String three = arr[2];
                switch (three) {
                    case "lat" : result = getAddress().getGeo().getLat(); break;
                    case "lng" : result = getAddress().getGeo().getLng(); break;

                }
            }

            return result;

        }

        public String getAddr(Address adr,String criteria)
        {
            String result = null;
            switch (criteria) {
                case "street" : result =adr.getStreet(); break;
                case "suite" : result = adr.getSuite(); break;
                case "city" : result =adr.getCity(); break;
                case "zipcode" : result = adr.getZipcode(); break;

            }
            return result;
        }

        public String getComp(Company comp,String criteria)
        {
            String result = null;
            switch (criteria) {
                case "name" : result =comp.getName(); break;
                case "basename" : result = comp.getBasename(); break;

            }
            return result;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("SampleResponse{");
            sb.append("id=").append(id);
            sb.append(", name='").append(name).append('\'');
            sb.append(", username='").append(username).append('\'');
            sb.append(", email='").append(email).append('\'');
            sb.append(", website='").append(website).append('\'');
            sb.append(", address=").append(address);
            sb.append(", company=").append(company);
            sb.append('}');
            return sb.toString();
        }
    }

    private static final String URL = "https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users";
    public static void main(String[] args) {
        System.out.println("hi");

        try {
            apiResponseParser(Arrays.asList("username","EQUALS", "vinayk"), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<SampleResponse> getSampleResponse() throws IOException {
        URL url = new URL(URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        InputStream stream = connection.getInputStream();

        BufferedReader in = new BufferedReader(new InputStreamReader(stream));
        String jsonResponseString = "";
        String current;

        while ((current = in.readLine()) != null) {
            jsonResponseString += current;
        }
        System.out.println(jsonResponseString.length());
        List<SampleResponse> responses = new ArrayList<>();
//        Type type = new TypeToken<List<SampleResponse>>(){}.getType();
//        List<SampleResponse> responses = new Gson().fromJson(jsonResponseString, type);
        System.out.println(responses);
        return responses;
    }

    public static List<Integer> apiResponseParser(List<String> inputList, int size) throws IOException {
        List<SampleResponse> responseList = getSampleResponse();
        String criteriaField = inputList.get(0);
        String criteriaType = inputList.get(1);
        String criteriaValue = inputList.get(2);

        List<Integer> result = new ArrayList<>();


        if(criteriaType.equals("EQUALS"))
        {
            for(SampleResponse response : responseList) {
                String value = response.getValue(criteriaField);

                if (value==null)
                {
                    value = response.getTwo(criteriaField);
                }
                if (value!=null && criteriaValue.equalsIgnoreCase(value))
                {
                    result.add(response.getId());
                }

            }
        }
        else
        {

            for(SampleResponse response : responseList) {
                List<String> curr = Arrays.stream(criteriaField.split(",")).collect(Collectors.toList());
                String value = response.getValue(criteriaField);

                if (value==null)
                {
                    value = response.getTwo(criteriaField);
                }
                if (value!=null && curr.contains(value))
                {
                    result.add(response.getId());
                }

            }

        }


        return result;


    }
}
