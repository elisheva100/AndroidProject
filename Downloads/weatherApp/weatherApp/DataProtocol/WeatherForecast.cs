using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataProtocol
{
    public class WeatherForecast
    {
        [Key]
        public string City { get; set; }
        public string Description { get; set; }
        public int icon { get; set; }
        public string IconID { get; set; }
        public DateTime Date { get; set; }
        public string WindSpeed { get; set; }
        public double Temperature { get; set; }
        public double MaxTemperature { get; set; }
        public double MinTemperature { get; set; }
        public string Humidity { get; set; }
        public string IconImage { get; set; }
        //public string cityID { get; set; }
        //public WeatherCity WeatherCity { get; set; }

        public override string ToString()
        {
            string result = "";
            result += "City: " + City + "\n" + "Description: " + Description + "\n" + "WindSpeed: " + WindSpeed + "\n" + "Temperature: " + Temperature + "\n" + "MaxTemperature: " + MaxTemperature + "\n" + "MinTemperature: " + MinTemperature + "\n" + "Humidity: " + Humidity+"%";
            return result;
        }
    }
}
