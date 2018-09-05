using DataProtocol;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace Dal
{
    public interface IDal
    {
        Task<WeatherForecast> GetCurrentWeatherAsync(string city);
        Task<IEnumerable<WeatherForecast>> GetWeekWeatherAsync(string city);
    }
}
