using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace DataProtocol
{
    public class WeatherCity
    {
        [Key]
        public DateTime date { get; set; }

        [ForeignKey("WeatherForecast")]
        public string City { get; set; }

        public WeatherForecast WeatherForecast { get; set; }
    }
}
