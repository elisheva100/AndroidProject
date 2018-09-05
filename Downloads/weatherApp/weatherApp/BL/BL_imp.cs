using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DataProtocol;
using Dal;

namespace BL
{
    public class BL_imp : IBL
    {
        Dal_imp mydal;
        public BL_imp()
        {
            mydal = new Dal_imp();
        }
        public Task<WeatherForecast> GetCurrentWeatherAsync(string city)
        {
            return mydal.GetCurrentWeatherAsync(city);
        }

        public Task<IEnumerable<WeatherForecast>> GetWeekWeather(string city)
        {
            return mydal.GetWeekWeatherAsync(city);
        }
    }
}
