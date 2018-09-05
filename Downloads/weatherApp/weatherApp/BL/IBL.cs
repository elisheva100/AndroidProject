using DataProtocol;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BL
{
    public interface IBL
    {
        Task<WeatherForecast> GetCurrentWeatherAsync(string city);
        Task<IEnumerable<WeatherForecast>> GetWeekWeather(string city);
    }
}
