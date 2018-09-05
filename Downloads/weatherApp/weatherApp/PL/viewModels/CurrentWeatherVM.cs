using DataProtocol;
using PLWPF.converts;
using PLWPF.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Media.Imaging;

namespace PLWPF.viewModels
{
    public class CurrentWeatherVM : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;
        private CurrentWeatherModel currentWeatherModel;
        public WeatherForecast current { get; set; }
        public IconConvert IC=new IconConvert();
        object[] values;

        public CurrentWeatherVM()
        {
            currentWeatherModel = new CurrentWeatherModel();
            current = new WeatherForecast();
            City = "Jerusalem"; //default city
            PropertyChanged += CurrentWeatherVM_PropertyChanged;
            PropertyChanged(this, new PropertyChangedEventArgs("City"));
        }
        
        public double Temperature { get; set; }
        public string Description { get; set; }
        private string humidity; 
        public string Humidity
        {
            get
            {
                return humidity;
            }
            set
            {
                humidity = value;
                PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(null));
            }
        }
        public string WindSpeed { get; set; }
        public string City
        {
            get { return currentWeatherModel.city; }
            set
            {
                currentWeatherModel.city = value;
                if (PropertyChanged != null)
                    PropertyChanged(this, new PropertyChangedEventArgs("City"));

            }
        }
        private BitmapImage icon;
        public BitmapImage Icon
        {
            get
            {
                //object[] values = new object[2];
                values[0] = current.icon;
                values[1] = current.IconID;
                return IC.WeatherIconConverter(values);
            }
            set
            {
                icon = value;
                PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(null));
            }
        }

        

            private async void CurrentWeatherVM_PropertyChanged(object sender, PropertyChangedEventArgs e)
        {
            if (e.PropertyName == "City")
            {
                current = await currentWeatherModel.GetCurrentWeather();
                Temperature = current.Temperature;// + " °C";
                WindSpeed = current.WindSpeed+ " meter/sec";
                Description = current.Description;
                Humidity = current.Humidity+"%";
                values = new object[2];
                values[0] = current.icon;
                values[1] = current.IconID;
                Icon = IC.WeatherIconConverter(values);
            }
        }

        
    }
}
