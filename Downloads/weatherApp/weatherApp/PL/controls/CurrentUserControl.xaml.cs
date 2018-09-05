using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using DataProtocol;
using PLWPF.viewModels;

namespace PLWPF.controls
{
    /// <summary>
    /// Interaction logic for UserControlWeather.xaml
    /// </summary>
    public partial class CurrentUserControl : UserControl
    {
        Cities citiesList;
        CurrentWeatherVM CurrentVM{ get; set; }
       
        public CurrentUserControl()
        {
            InitializeComponent();
            citiesList = new Cities();
            CurrentVM = new CurrentWeatherVM();
            DataContext = CurrentVM;
            this.cities.ItemsSource = citiesList.MyCities;
        }

    }
}
