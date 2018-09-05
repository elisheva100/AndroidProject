using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using PLWPF.command;
using System.Windows.Controls;
using PLWPF.controls;
using PLWPF.Models;
using DataProtocol;
using System.Collections.ObjectModel;
using PLWPF.converts;
using System.Windows.Media.Imaging;

namespace PLWPF.viewModels
{
    public class MapVM : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;
        public MapCommand ChangeMiniView { get; set; }
        public MiniWeeklyUserControl miniWeekly { get; set; }
        MapModel MapModel;
        IEnumerable<WeatherForecast> WeeklyWeather;
        private ObservableCollection<WeatherForecast> forecasts;
        IconConvert IC = new IconConvert();
        object[] values = new object[2];

        //private MiniWeeklyUserControl miniWeekly;
        //public MiniWeeklyUserControl MiniWeekly
        //{
        //    get { return miniWeekly; }
        //    set
        //    {
        //        if (miniWeekly == value)
        //            return;
        //        miniWeekly = value;

        //        if (PropertyChanged != null)
        //            PropertyChanged(this, new PropertyChangedEventArgs("MiniWeekly"));
        //    }
        //}

        public MapVM()
        {
            ChangeMiniView = new MapCommand();
            ChangeMiniView.CanExecuteChanged += ChangeMiniView_CanExecuteChanged;
            miniWeekly = new MiniWeeklyUserControl();
            MapModel = new MapModel();
            PropertyChanged += WeeklyVM_PropertyChanged;
            MiniGeneral = miniWeekly;
            ChangeMiniView_CanExecuteChanged("Jerusalem", new EventArgs());
        }

        private void ChangeMiniView_CanExecuteChanged(object sender, EventArgs e)
        {
            City = (string)sender;
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
                WeeklyWeather = await MapModel.GetWeeklyWeather();
                Forecasts = new ObservableCollection<WeatherForecast>(WeeklyWeather);// convert.GetDailyWeather(x));

                for (int i = 0; i < WeeklyWeather.Count(); i++)
                {
                    values = new object[2];
                    values[0] = Forecasts.ElementAt<WeatherForecast>(i).icon;
                    values[1] = Forecasts.ElementAt<WeatherForecast>(i).IconID;
                    Icon = IC.WeatherIconConverter(values);
                    Forecasts.ElementAt<WeatherForecast>(i).IconImage = Icon.UriSource.ToString();
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
            get { return MapModel.city; }
            set
            {
                MapModel.city = value;
                if (PropertyChanged != null)
                    PropertyChanged(this, new PropertyChangedEventArgs("City"));

            }
        }
        

        private UserControl general;
        public UserControl MiniGeneral
        {
            get { return general; }
            set
            {
                if (general == value)
                    return;
                general = value;

                if (PropertyChanged != null)
                    PropertyChanged(this, new PropertyChangedEventArgs("MiniGeneral"));
            }
        }
    }
}
