using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BL;
using DataProtocol;

namespace PLWPF.Models
{
    public class CurrentWeatherModel
    {
        public BL_imp myBL { get; set; }
        public string city;

        public CurrentWeatherModel()
        {
            myBL = new BL_imp();
        }

        public async Task<WeatherForecast> GetCurrentWeather()
        {
            return await myBL.GetCurrentWeatherAsync(city);   
        }

    }
}
