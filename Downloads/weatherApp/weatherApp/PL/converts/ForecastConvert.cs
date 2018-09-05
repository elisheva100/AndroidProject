using DataProtocol;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PLWPF.converts
{
    public class ForecastConvert
    {
        public List<WeatherForecast> GetDailyWeather(IEnumerable<WeatherForecast> weather1)
        {
            int icon=0;
            string iconID="";
            List<WeatherForecast> weather = weather1.ToList();

            List<WeatherForecast> Forecast = new List<WeatherForecast>();
            int j = 0;
            int k = 0;
            int p = weather.Count();
            while (j < 3 && k < weather.Count())
            {
                DateTime nullptr = default(DateTime);
                DateTime date = nullptr;
                WeatherForecast nullptr1 = default(WeatherForecast);
                WeatherForecast cur = nullptr1;
                double mint = 0;
                double maxt = 100000;
                for (int i = k; i < weather.Count(); i++)
                {
                    var w = weather.ElementAt<WeatherForecast>(i);
                    DateTime newdate = w.Date;
                    k = i + 1;
                    if (date == nullptr)
                    {
                        date = newdate;
                        cur = w;
                        mint = w.MinTemperature;
                        maxt = w.MaxTemperature;
                    }
                    else if (date.Day.Equals(newdate.Day))
                    {
                        mint = (mint < w.MinTemperature) ? mint : w.MinTemperature;
                        //maxt = (maxt > w.MaxTemperature) ? maxt : w.MaxTemperature;
                        if(maxt < w.MaxTemperature)
                        {
                            maxt = w.MaxTemperature;
                            icon = w.icon;
                            iconID = w.IconID;
                        }
                    }
                    else break;
                }
                cur.MaxTemperature = maxt;
                cur.MinTemperature = mint;
                cur.icon = icon;
                cur.IconID = iconID;
                Forecast.Add(cur);
            }
            return Forecast;
        }
    }
}
