using DataProtocol;
using PLWPF.viewModels;
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

namespace PLWPF.controls
{
    /// <summary>
    /// Interaction logic for WeeklyUserControl.xaml
    /// </summary>
    public partial class WeeklyUserControl : UserControl
    {
        public WeeklyVM weeklyVM { get; set; }
        Cities citiesList;

        public WeeklyUserControl()
        {
            InitializeComponent();
            weeklyVM = new WeeklyVM();
            DataContext = weeklyVM;
            citiesList = new Cities();
            this.cities.ItemsSource = citiesList.MyCities;
        }
    }
}
