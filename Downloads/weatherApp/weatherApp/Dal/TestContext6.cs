using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DataProtocol;

namespace Dal
{
    public class TestContext6: DbContext
    {
        public TestContext6():base()
        {
            //Database.SetInitializer<DB_context>(null);
        }
        public DbSet<WeatherForecast> Weathers { get; set; }
        public DbSet<WeatherCity> WeatherCities { get; set; }
    }
}
