using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Media.Imaging;

namespace PLWPF.converts
{
    public class IconConvert
    {
        public BitmapImage WeatherIconConverter(object[] values)
        {

            var id = (int)values[0];
            var iconID = (string)values[1];


            var timePeriod = iconID.ToCharArray()[2]; // This is either d or n (day or night)
            //var pack = "C:/Users/owner/Documents/Reut/הנדסת מערכות חלונות/weatherApp/PL/WeatherIcons/";
            var pack = "C:/Users/owner/Desktop/weatherApp/PL/WeatherIcons/";
            var img = string.Empty;

            if (id >= 200 && id < 300) img = "thunderstorm.png";
            else if (id >= 300 && id < 500) img = "drizzle.png";
            else if (id >= 500 && id < 600) img = "rain.png";
            else if (id >= 600 && id < 700) img = "snow.png";
            else if (id >= 700 && id < 800) img = "atmosphere.png";
            else if (id == 800) img = (timePeriod == 'd') ? "clear_day.png" : "clear_night.png";
            else if (id == 801) img = (timePeriod == 'd') ? "few_clouds_day.png" : "few_clouds_night.png";
            else if (id == 802 || id == 803) img = (timePeriod == 'd') ? "broken_clouds_day.png" : "broken_clouds_night.png";
            else if (id == 804) img = "overcast_clouds.png";
            else if (id >= 900 && id < 903) img = "extreme.png";
            else if (id == 903) img = "cold.png";
            else if (id == 904) img = "hot.png";
            else if (id == 905 || id >= 951) img = "windy.png";
            else if (id == 906) img = "hail.png";

            Uri source = new Uri(pack + img);

            BitmapImage bmp = new BitmapImage(source);

            return bmp;
        }
    }
}
