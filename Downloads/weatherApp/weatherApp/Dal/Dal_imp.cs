using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DataProtocol;
using System.Net.Http;
using System.Xml.Linq;
using System.IO;

namespace Dal
{
    public class Dal_imp : IDal
    {
        private const string APP_ID = "2a23e52bcf8722a26b21528a491c398e";//"ba64d5953c7a395c6d415a855851ff83";
        //private const string APP_ID_daily = "542ffd081e67f4512b705f89d2a611b2";
        private HttpClient client;
        string City;
        public static int fakeid=0;
        public Dal_imp()
        {
            client = new HttpClient();
            client.BaseAddress = new Uri("http://api.openweathermap.org/data/2.5/");
        }

        public void SaveWeather(WeatherForecast weather)
        {
            using (var db = new TestContext6())
            {
                if (db.Weathers.Any(W => W.City == weather.City))
                { 
                    var bye = (from x in db.Weathers
                              where x.City == weather.City
                              select x).FirstOrDefault();
                    db.Weathers.Remove(bye);
                }
                var w = new WeatherForecast()
                {
                    City = weather.City,
                    Description = weather.Description,
                    Humidity = weather.Humidity,
                    icon = weather.icon,
                    IconID = weather.IconID,
                    Date = weather.Date,
                    MaxTemperature = weather.MaxTemperature,
                    MinTemperature = weather.MinTemperature,
                    Temperature = weather.Temperature,
                    WindSpeed = weather.WindSpeed
                };
                db.Weathers.Add(w);
                db.SaveChanges();
            }
        }

        public async Task<WeatherForecast> GetCurrentWeatherAsync(string city)
        {
            string urlcontents;
            WeatherForecast urlContents;
            try
            {
                urlContents = await AccessTheWebAsync();
                SaveWeather(urlContents);
                return urlContents;
            }
            catch (Exception)
            {
                using (var db = new TestContext6())
                {
                   WeatherForecast query;
                   return query = (from w in db.Weathers
                                where w.City==city
                                select w).FirstOrDefault();
                }
            }
            
         
            async Task<WeatherForecast> AccessTheWebAsync()
            { 
                var query = $"weather?q="+city+ "&mode=xml&units=metric&APPID=" + APP_ID;
                Task<string> getStringTask = client.GetStringAsync(query);                
                urlcontents = await getStringTask;
                var x = XElement.Load(new StringReader(urlcontents));
                var data = new WeatherForecast
                {
                    City = x.Element("city").Attribute("name").Value,
                    Date = DateTime.Today,
                    Description = x.Element("weather").Attribute("value").Value,
                    icon= int.Parse(x.Element("weather").Attribute("number").Value),
                    IconID = x.Element("weather").Attribute("icon").Value,
                    WindSpeed = x.Element("wind").Element("speed").Attribute("value").Value,
                    Temperature= double.Parse(x.Element("temperature").Attribute("value").Value),
                    MaxTemperature = double.Parse(x.Element("temperature").Attribute("max").Value),
                    MinTemperature = double.Parse(x.Element("temperature").Attribute("min").Value),
                    Humidity = x.Element("humidity").Attribute("value").Value
                }; 

                return data;
            }
        }


        public async Task<IEnumerable<WeatherForecast>> GetWeekWeatherAsync(string city)
        {
            string urlcontents;
            City = city;
            IEnumerable <WeatherForecast> urlContents;
            try
            {
                //urlContents = await AccessTheWebAsync();
                //SaveForecast(urlContents);
                DateTime date = new DateTime();

                urlContents = new List<WeatherForecast>() { new WeatherForecast() { Date = date,IconID= "01n", icon=904,MinTemperature=23.56,MaxTemperature=34.56 } , new WeatherForecast() { Date = date, IconID = "01n", icon = 904, MinTemperature = 23.56, MaxTemperature = 34.56 } , new WeatherForecast() { Date = date, IconID = "01n", icon = 905, MinTemperature = 23.56, MaxTemperature = 34.56 } , new WeatherForecast() { Date = date, IconID = "01n", icon = 906, MinTemperature = 23.56, MaxTemperature = 34.56 } , new WeatherForecast() { Date = date, IconID = "01n", icon = 904, MinTemperature = 23.56, MaxTemperature = 34.56 } };
                return urlContents;
            }
            catch (Exception)
            {
                using (var db = new TestContext6())
                {
                    var query = (from w in db.WeatherCities
                             where w.City == city
                             select w.WeatherForecast);
                    
                    return query;
                }
            }


            async Task<IEnumerable<WeatherForecast>> AccessTheWebAsync()
            {
                var query = $"forecast?q=" + city + "&mode=xml&units=metric&APPID=" + APP_ID;
                Task <string> getStringTask = client.GetStringAsync(query);
                urlcontents = await getStringTask;
                var x = XElement.Load(new StringReader(urlcontents));
                IEnumerable <WeatherForecast> data = x.Descendants("time").Select(w => new WeatherForecast
                {
                    City = city,
                    Date= DateTime.Parse(w.Attribute("to").Value),
                    icon =int.Parse(w.Element("symbol").Attribute("number").Value),
                    IconID = w.Element("symbol").Attribute("var").Value,
                    Description=w.Element("symbol").Attribute("name").Value,
                    MaxTemperature = double.Parse(w.Element("temperature").Attribute("max").Value),
                    MinTemperature = double.Parse(w.Element("temperature").Attribute("min").Value)
                });

                return data;
            }
            
        }

        public void SaveForecast(IEnumerable<WeatherForecast> data)
        {
            //WeatherCity weatherC = new WeatherCity();
            //weatherC.City = City; //City;
            //weatherC.date = ;
            //weatherC.weatherList = data.ToList();
            using (var db = new TestContext6())
            {
                var q = db.WeatherCities.Where(W => W.City == City);
                if (q!=null)//db.WeatherCities.Any(W => W.City == City))
                {
                    var bye = (from x in db.WeatherCities
                               where x.City == City
                               select x);
                    db.WeatherCities.RemoveRange(bye);
                }
                foreach (var item in data)
                {
                    WeatherCity weatherC = new WeatherCity();
                    weatherC.City = City; 
                    weatherC.date =item.Date ;
                    WeatherForecast forecast = new WeatherForecast()
                    {
                        Date = item.Date,
                        //City = item.City,
                        City = fakeid++.ToString(),
                        Description = item.Description,
                        MinTemperature = item.MinTemperature,
                        MaxTemperature = item.MaxTemperature,
                        icon = item.icon,
                        IconID = item.IconID
                    };
                    weatherC.WeatherForecast = forecast;
                    db.WeatherCities.Add(weatherC);
                    db.SaveChanges();
                }
                
            }
        }
    }
}
