using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DataProtocol;
using System.ComponentModel;
using PLWPF.Models;
using PLWPF.converts;
using System.Collections.ObjectModel;
using System.Windows.Media.Imaging;

namespace PLWPF.viewModels
{
    public class WeeklyVM:INotifyPropertyChanged
    {
        
        public event PropertyChangedEventHandler PropertyChanged;
        WeeklyModel weeklyModel;
        IEnumerable<WeatherForecast> WeeklyWeather;
        private ObservableCollection<WeatherForecast> forecasts;
        IconConvert IC = new IconConvert();
        object[] values = new object[2];

        public WeeklyVM()
        {
            weeklyModel = new WeeklyModel();
            PropertyChanged += WeeklyVM_PropertyChanged; 
        }
        
        public ObservableCollection<WeatherForecast> Forecasts
        {
            get { return forecasts; }
            set
            {
                if (PropertyChanged != null)
                    forecasts = value;
                PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(null));
            }
        }
        ForecastConvert convert = new ForecastConvert();

        

        private async void WeeklyVM_PropertyChanged(object sender, PropertyChangedEventArgs e)
        {
            if (e.PropertyName == "City")
            {
                WeeklyWeather = await weeklyModel.GetWeeklyWeather();
                Forecasts = new ObservableCollection<WeatherForecast>(WeeklyWeather);// convert.GetDailyWeather(WeeklyWeather));

                for (int i = 0; i < WeeklyWeather.Count(); i++)
                {
                    values = new object[2];
                    values[0] = Forecasts.ElementAt<WeatherForecast>(i).icon;
                    values[1] = Forecasts.ElementAt<WeatherForecast>(i).IconID;
                    Icon = IC.WeatherIconConverter(values);
                    Forecasts.ElementAt<WeatherForecast>(i).IconImage=Icon.UriSource.ToString();
                }
            }
        }

        private BitmapImage icon;
        public BitmapImage Icon
        {
            get
            {
                return IC.WeatherIconConverter(values);
            }
            set
            {
                icon = value;
                PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(null));
            }
        }

        public string City
        {
            get { return weeklyModel.city; }
            set
            {
                weeklyModel.city = value;
                if (PropertyChanged != null)
                    PropertyChanged(this, new PropertyChangedEventArgs("City"));

            }
        }
    }
}
