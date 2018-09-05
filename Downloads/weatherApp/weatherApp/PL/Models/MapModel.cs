using BL;
using DataProtocol;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PLWPF.Models
{
    public class MapModel
    {
        public BL_imp myBL { get; set; }
        public string city;

        public MapModel()
        {
            myBL = new BL_imp();
        }


        public async Task<IEnumerable<WeatherForecast>> GetWeeklyWeather ()
        {
            return await myBL.GetWeekWeather(city);
        }
    }
}
